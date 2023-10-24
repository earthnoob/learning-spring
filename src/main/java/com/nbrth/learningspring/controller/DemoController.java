package com.nbrth.learningspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String helloWorld(Model theModel) {
        theModel.addAttribute("theDate", new java.util.Date());
        return "helloWorld";
    }

}
