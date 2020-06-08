package com.base.controller;


import javax.validation.Valid;  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.validation.BindingResult;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.model.User;  
@RequestMapping("/new")
@Controller  
public class UserController {  

  @RequestMapping("/hello")  
  public String display(Model m)  
  {  
      m.addAttribute("emp", new User());  
      return "viewpage";  
  }  
  @RequestMapping("/helloagain")  
  public String submitForm( @Valid @ModelAttribute("emp") User e, BindingResult br)  
  {  
      if(br.hasErrors())  
      {  
          return "viewpage";  
      }  
      else  
      {  
      return "final";  
      }  
  }  
} 