package com.kevinmvc.testsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
    @RequestMapping("/Profile")
    public String displayProfile(){
        return "profile/profilePage";
    }
}
