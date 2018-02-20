package com.kevinmvc.testsite.Profile;

import com.kevinmvc.testsite.date.USLocalDateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class ProfileController {
    @RequestMapping("/Profile")
    public String displayProfile(ProfileForm profileForm){
        return "profile/profilePage";
    }
    @RequestMapping(value="/profile",method= RequestMethod.POST)
    public String saveProfile(ProfileForm profileForm)
    {
        System.out.println("save ok"+profileForm);
        return "redirect:profile";
    }

    @ModelAttribute("dateFormat")
    public String localeFormat(Locale locale)
    {
        return USLocalDateFormatter.getPattern(locale);
    }
}
