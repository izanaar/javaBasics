package com.spittr.web;

import com.spittr.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    @Autowired
    private SpittleRepository spittleRepository;

    @RequestMapping("get")
    public String getSpittles(Model model){
        model.addAttribute(spittleRepository.getSpittles(0,20));
        return "spittles";
    }

}
