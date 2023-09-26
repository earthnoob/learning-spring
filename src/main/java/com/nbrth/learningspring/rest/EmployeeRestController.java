package com.nbrth.learningspring.rest;

import com.nbrth.learningspring.entity.Employee;
import com.nbrth.learningspring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    // Inject employee service
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Expose "/employee" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

}
