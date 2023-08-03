package com.nbrth.learningspring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // Expose "/" that returns "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    // Expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    // Expose a new endpoint for "Fortune"
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day!";
    }

}
