/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.invetory.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import za.co.eoh.invetory.management.entity.Asset;
import za.co.eoh.invetory.management.entity.Role;
import za.co.eoh.invetory.management.entity.User;
import za.co.eoh.invetory.management.entity.UserAsset;
import za.co.eoh.invetory.management.forms.LoginForm;
import za.co.eoh.invetory.management.forms.UserForm;
import za.co.eoh.invetory.management.service.AssetService;
import za.co.eoh.invetory.management.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author thakgatso
 */
@Controller
@RequestMapping(value = "/users")
@SessionAttributes({"userInfo"})
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private AssetService assetService;


  @RequestMapping(value = "/viewUsers.htm")
  public String viewUsers(Model model) {
    List<User> users = userService.getAllUser();
    model.addAttribute("usersList", new HashSet<>(users) );
    return "admin/users/viewUsers";
  }

  @RequestMapping(value = "/logout.htm")
  public String logout(HttpServletRequest request, SessionStatus sessionStatus, Model model) {
    request.getSession().invalidate();
    sessionStatus.setComplete();
    return "redirect:/index.htm";
  }

  @RequestMapping(value = "/login.htm")
  public String login(Model model, @ModelAttribute("loginForm") LoginForm loginForm) {
    User user = userService.login(loginForm.getUsername(), loginForm.getPassword());
    if (user == null) {
      model.addAttribute("loginFailed", "loginFailed");
      return "index";
    } else {
      model.addAttribute("userInfo", user);
      if (user.getUserRole() != null && "admin".equalsIgnoreCase(user.getUserRole().getName())) {
        return "admin/adminHome";
      }
      return "normal-users/profile";
    }
  }

  @RequestMapping(value = "/delete.htm")
  public String delete(@RequestParam(value = "id") Integer id, Model model) throws Exception {
    try {
      User user = userService.getUserById(id);
      userService.deleteUser(user);
      model.addAttribute("userMessage", "User with id: " + user.getUserID() + " successfully deleted");
    } catch (Exception exc) {
      model.addAttribute("userError", "Failed to delete Asset: " + exc.getMessage());
    }
    return viewUsers(model);
  }

  @RequestMapping(value = "/viewUpdateUser.htm")
  public String viewUpdateUserPage(Model model, @RequestParam(value = "id") Integer id) {
    User user = userService.getUserById(id);
    UserForm userForm = new UserForm();
    if (user != null) {
      userForm.setBusinessUnt(user.getBusinessUnt());
      userForm.setComment(user.getComment());
      userForm.setPassword(user.getPassword());
      userForm.setUserRole(user.getUserRole());
      userForm.setUsername(user.getUsername());
      userForm.setUserID(user.getUserID());
      userForm.setUserRoleId(user.getUserRole().getRoleID());
      List<Integer> userAssignedAssets = user.getAssignedAssets().stream().map(UserAsset::getAssetID).collect(Collectors.toList());
      userForm.setUserAssets(userAssignedAssets);
    }
    model.addAttribute("userForm", userForm);
    model.addAttribute("assetsList", assetService.getAllAssets());
    return "admin/users/addUpdateUser";
  }

  @RequestMapping(value = "/viewAddUser.htm")
  public String viewAddUserPage(Model model) {
    model.addAttribute("userForm", new UserForm());
    model.addAttribute("assetsList", assetService.getAllAssets());
    return "admin/users/addUpdateUser";
  }


  @RequestMapping(value = "/addUpdateUser.htm")
  public String addOrUpdateUser(Model model, @ModelAttribute("userForm") UserForm form) {
    try {
      System.out.println("addUpdateUser: \n" + form + "\n" + form.getUserAssets());
      User user = new User();
      user.setUserID(form.getUserID());
      user.setUsername(form.getUsername());
      user.setPassword(form.getPassword());
      user.setComment(form.getComment());
      user.setBusinessUnt(form.getBusinessUnt());
      Role userRole = new Role();
      if (form.getUserRoleId() != null) {
        userRole.setRoleID(form.getUserRoleId());
      } else {
        userRole.setRoleID(2); //Normal user by default
      }

      user.setUserRole(userRole);
      List<UserAsset> userAssetList = new ArrayList<>();

      if (form.getUserAssets() != null && !form.getUserAssets().isEmpty()) {
        for (Asset asset : findAssets(form.getUserAssets())) {
          UserAsset userAsset = new UserAsset();
          userAsset.setAsset(asset);
          userAsset.setUser(user);
          userAssetList.add(userAsset);
        }
        user.setAssignedAssets(userAssetList);
      } else {
        user.setAssignedAssets(new ArrayList<>());
      }

      userService.mergeUser(user);
      model.addAttribute("userMessage", "User with id: " + user.getUserID() + " added/updated successfully");
    } catch (Exception exc) {
      model.addAttribute("userError", "Failed to add or update  USer: " + exc.getMessage());
      exc.printStackTrace();
    }
    return viewUsers(model);
  }

  private List<Asset> findAssets(List<Integer> assetsId) {
    List<Asset> assets = new ArrayList<>();
    for (Integer id : assetsId) {
      assets.add(assetService.getAssetById(id));
    }
    return assets;
  }
}
