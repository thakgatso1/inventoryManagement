/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.webapp.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.eoh.webapp.entity.User;
import za.co.eoh.webapp.forms.AddAssetsForm;
import za.co.eoh.webapp.forms.AddUserForm;
import za.co.eoh.webapp.service.AssetService;
import za.co.eoh.webapp.service.UserService;

/**
 *
 * @author thakgatso
 */
@Controller
public class UserController {
 @Autowired
    private UserService userService;
    @RequestMapping(value = "/addUpdateUser.htm")
    public String addUser(Model model, @ModelAttribute("addUserForm") AddUserForm form) {
        try {
            User user = new User();
            System.out.println(form);
            user.setUsername(form.getUsername());
            user.setPassword(form.getPassword());
            user.setBusinessUnt(form.getBusinessUnt());
            user.setComment(form.getComment());
           //user.setRoleID(roleID);
            //user.setAssignmentList(null);
            userService.saveOrUpdateUser(user);

            model.addAttribute("msg", "Successfully added to the database");
        } catch (Exception exc) {

        }

        return "asset/addAsset";
    }
}
