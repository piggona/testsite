package com.kevinmvc.testsite.Profile;

import com.kevinmvc.testsite.date.USLocalDateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

@Controller
public class ProfileController {
    @RequestMapping("/profile")
    public String displayProfile(ProfileForm profileForm){
        return "profile/profilePage";
    }
    @RequestMapping(value="/profile",params = {"save"}, method= RequestMethod.POST)
    public String saveProfile(@Valid ProfileForm profileForm,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "profile/profilePage";
        }
        System.out.println("save ok"+profileForm);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/profile",params = {"addTaste"})
    public String addRow(ProfileForm profileForm)
    {
        profileForm.getTaste().add(null);
        return "profile/profilePage";
    }

    @RequestMapping(value = "profile",params = {"removeTaste"})
    public String removeRow(ProfileForm profileForm, HttpServletRequest req)
    {
        Integer rowId=Integer.valueOf(req.getParameter("removeTaste"));
        profileForm.getTaste().remove(rowId.intValue());
        return "profile/profilePage";
    }


    @ModelAttribute("dateFormat")//相当于model.addAttribute()将return的字符串加入"dateFormat"库
    public String localeFormat(Locale locale)
    {
        return USLocalDateFormatter.getPattern(locale);
    }
}
