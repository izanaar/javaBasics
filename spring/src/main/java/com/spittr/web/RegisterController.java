package com.spittr.web;

import com.spittr.model.Spitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;


@Controller
@RequestMapping("/register")
public class RegisterController {

    @RequestMapping(method = RequestMethod.GET)
    public String getPage(Model model){
        model.addAttribute(getSpitterShape());
        return "register";
    }

    private Spitter getSpitterShape(){
        Spitter spitter = new Spitter();
        spitter.setFirstName("John");
        spitter.setLastName("Doe");
        spitter.setEmail("johndoe@somedomain.com");
        spitter.setUsername("jhdoe");
        spitter.setPassword("123456");
        return spitter;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(@Valid Spitter spitter, @RequestPart("textFile") MultipartFile file,
                           Errors errors){

        if (errors.hasErrors()) {
            return "register";
        }

        return "redirect:/";
    }

}
