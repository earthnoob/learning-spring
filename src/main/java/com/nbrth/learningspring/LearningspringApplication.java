package com.nbrth.learningspring;

import com.nbrth.learningspring.dao.StudentDAO;
import com.nbrth.learningspring.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearningspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningspringApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			System.out.println("Hello World");
			createStudent(studentDAO);
		};
	}

	public void createStudent(StudentDAO studentDAO) {

		// Create the student object
		System.out.println("Creating new student object...");
		Student student = new Student("John", "Doe", "johndoe@mail.com");

		// Save the student object
		System.out.println("Saving the student...");
		studentDAO.save(student);

		// Display id of saved student
		System.out.println("Saved student. Generated id: " + student.getId());

	}

}
