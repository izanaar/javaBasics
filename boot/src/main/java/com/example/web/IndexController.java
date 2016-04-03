package com.example.web;

import com.example.service.PropertiesProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @Autowired
    private PropertiesProvider provider;

    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("greeting", "Hello");
        model.addAttribute("prop1", provider.getProp1());
        model.addAttribute("overriden", provider.getOverridenProp());
        return "index";
    }


}
