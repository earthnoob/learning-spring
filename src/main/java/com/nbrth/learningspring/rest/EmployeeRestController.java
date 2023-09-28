package com.nbrth.learningspring.rest;

import com.nbrth.learningspring.entity.Employee;
import com.nbrth.learningspring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable(name = "employeeId") int id) {
        return employeeService.findById(id);
    }

    // Add mapping for POST /employees - Add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // Set id to 0 in case users pass in id
        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") int id) {
        if (Objects.isNull(employeeService.findById(id))) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        employeeService.deleteById(id);

        return "Deleted employee id - " + id;
    }

}
