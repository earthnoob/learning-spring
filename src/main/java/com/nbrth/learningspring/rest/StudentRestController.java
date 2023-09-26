package com.nbrth.learningspring.rest;

import com.nbrth.learningspring.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> theStudents = new ArrayList<>() {
            {
                add(new Student("John", "Doe"));
                add(new Student("Jane", "Doe"));
                add(new Student("Bella", "Jones"));
            }
        };

        return theStudents;
    }

}
