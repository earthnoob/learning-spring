package com.nbrth.learningspring.dao;

import com.nbrth.learningspring.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // Define field for EntityManager
    private EntityManager entityManager;

    // Set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // Create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // Execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // Return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // Get employee
        Employee employee = entityManager.find(Employee.class, id);

        // Return employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        // Save and return employee
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        // Find employee by id
        Employee employee = entityManager.find(Employee.class, id);

        // Remove employee
        entityManager.remove(employee);
    }

}
