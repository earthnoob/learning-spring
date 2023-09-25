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
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		};

	}

	public void readStudent(StudentDAO studentDAO) {

		// Create a student object
		System.out.println("Creating the student object...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@mail.com");

		// Save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// Display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// Retrieve student based on the id: Primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// Display student
		System.out.println("Found the student: " + myStudent);

	}

	public void createMultipleStudents(StudentDAO studentDAO) {

		// Create the student object
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("Paul", "Doe", "pauldoe@mail.com");
		Student tempStudent2 = new Student("Mary", "Jane", "maryjane@mail.com");
		Student tempStudent3 = new Student("Mojito", "Party", "mojitoparty@mail.com");

		// Save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

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
