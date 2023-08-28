package com.nbrth.learningspring.common;

public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Do 100 reps!";
    }
}
