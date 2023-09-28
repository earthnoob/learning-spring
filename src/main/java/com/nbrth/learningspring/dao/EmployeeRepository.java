package com.nbrth.learningspring.dao;

import com.nbrth.learningspring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
