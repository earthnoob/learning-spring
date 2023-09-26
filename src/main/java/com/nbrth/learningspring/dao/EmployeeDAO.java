package com.nbrth.learningspring.dao;

import com.nbrth.learningspring.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
