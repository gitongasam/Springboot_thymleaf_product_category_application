package com.example.thymleaf1.Controller;

import org.springframework.stereotype.Controller;

@Controller
public class AppController {
    public String viewHomePage(){
        return "index";
    }
}
