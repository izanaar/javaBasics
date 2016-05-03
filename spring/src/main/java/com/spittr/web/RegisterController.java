package com.spittr.web;

import com.spittr.model.Spitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping("/register")
public class RegisterController {

    @RequestMapping(method = RequestMethod.GET)
    public String getPage(Model model){
        model.addAttribute(new Spitter());
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(@Valid Spitter spitter,
            Errors errors){

        if (errors.hasErrors()) {
            return "register";
        }

        return "redirect:/";
    }

}
