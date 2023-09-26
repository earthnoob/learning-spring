package com.nbrth.learningspring.rest;

import com.nbrth.learningspring.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // Define @PostConstruct to load the student data only once
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>() {
            {
                add(new Student("John", "Doe"));
                add(new Student("Jane", "Doe"));
                add(new Student("Bella", "Jones"));
            }
        };
    }

    // Define endpoint for "/students" - Return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // Define endpoint for "/students/{studentId}" - Return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        try {
            return theStudents.get(studentId);
        } catch (RuntimeException ex) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
    }

}
