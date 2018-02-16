package com.kevinmvc.testsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainApp {

    @RequestMapping("/getHello")
    public String hello(Model model){
        model.addAttribute("message","Hello from the controller");
        return "resultPage";
    }
    @RequestMapping("/user")
    public String getUser(@RequestParam("userid") String userid,@RequestParam("message") String message,Model model){
        model.addAttribute("userid",userid);
        model.addAttribute("message",message);
        System.out.println(message);
        return "resultPage";
    }
}
