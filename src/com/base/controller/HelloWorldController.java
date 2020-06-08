package com.base.controller;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  

@Controller 
@RequestMapping("/tiles") 
public class HelloWorldController {  
    @RequestMapping("/hello")  
    public String helloWorld(Model m) {  
        String message = "Hello World, Spring MVC @ Mukesh Sharma";  
        m.addAttribute("message", message);  
        return "hello";   
    }  
}