package com.spittr.web;

import com.spittr.data.SpittleRepository;
import com.spittr.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    @Autowired
    private SpittleRepository spittleRepository;

    @RequestMapping("get")
    public String getSpittles(Model model) {
        model.addAttribute(spittleRepository.getSpittles(0, 20));
        return "spittles";
    }

    @RequestMapping("get/{spittleId}")
    public String getSpittle(@PathVariable Long spittleId, Model model) {
        Spittle spittle = spittleRepository.findOne(spittleId);
        model.addAttribute(spittle);
        return "spittles";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveSpittle(Spittle spittle) {

        return "spittles";
    }

}
