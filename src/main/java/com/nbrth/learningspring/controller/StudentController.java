package com.nbrth.learningspring.controller;

import com.nbrth.learningspring.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class StudentController {

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        // Crate a student object
        Student theStudent = new Student();

        // Add the student object to the model
        theModel.addAttribute("student", theStudent);

        return "student-form";

    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent) {

        // Log the input data
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
        return "student-confirmation";

    }

}
