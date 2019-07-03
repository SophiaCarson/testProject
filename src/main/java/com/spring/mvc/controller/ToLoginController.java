package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class ToLoginController {
    @RequestMapping("/ToLoginController")
    public String toLogin(){
        return "login";
    }
}
