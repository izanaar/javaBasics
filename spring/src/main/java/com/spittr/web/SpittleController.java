package com.spittr.web;

import com.spittr.data.DuplicateSpittleException;
import com.spittr.data.SpittleRepository;
import com.spittr.model.Spittle;
import com.spittr.model.dto.SpittleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

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
    public String saveSpittle(SpittleDTO spittleDTO, Model model) {
        Spittle spittle = spittleDTO.toSpittle();
        spittleRepository.saveSpittle(spittle);
        return "redirect:/spittles";
    }


    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicateSpittle() {
        return "error/duplicate";
    }

}
