package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("key1","hello world");
        model.addAttribute("key2",123456);

        Map map = new HashMap();
        //JDBCOperation.insert(new JDBCOperation.Student("201621102009", "sophie", "female","20"));
        //JDBCOperation.getAll(map);


        model.addAttribute("map",map);



        System.out.printf("hello world");
        return "login";
    }
}
