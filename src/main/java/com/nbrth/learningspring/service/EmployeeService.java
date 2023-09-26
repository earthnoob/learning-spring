package com.nbrth.learningspring.service;

import com.nbrth.learningspring.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

}
