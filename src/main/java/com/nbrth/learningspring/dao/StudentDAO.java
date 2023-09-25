package com.nbrth.learningspring.dao;

import com.nbrth.learningspring.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

}
