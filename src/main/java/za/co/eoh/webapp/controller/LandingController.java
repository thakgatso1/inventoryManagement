package za.co.eoh.webapp.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandingController {

  @RequestMapping(value = "/index.htm")
  public String goToIndex(HttpServletRequest request, Model model) throws Exception {

    return "index";
  }

}
