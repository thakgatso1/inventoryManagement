package za.co.eoh.invetory.management.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.eoh.invetory.management.forms.LoginForm;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

  @RequestMapping(value = "/index.htm")
  public String goToIndex(HttpServletRequest request, Model model) throws Exception {
    if (!model.containsAttribute("loginForm")) {
      model.addAttribute("loginForm", new LoginForm());
    }
    return "index";
  }

}
