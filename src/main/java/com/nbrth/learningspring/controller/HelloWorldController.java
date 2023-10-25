package com.nbrth.learningspring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // New controller method to show initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // Controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloWorld";
    }

    // Controller method to read form data and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        // Read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // Convert the data to all caps
        theName = theName.toUpperCase();

        // Create the result
        String result = "Yo! " + theName;

        // Add result to the model
        model.addAttribute("message", result);

        return "helloWorld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {

        // Convert the data to all caps
        theName = theName.toUpperCase();

        // Create the result
        String result = "Hey ya! " + theName;

        // Add result to the model
        model.addAttribute("message", result);

        return "helloWorld";
    }

}
