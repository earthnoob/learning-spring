package com.nbrth.learningspring;

import java.util.List;
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
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
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

	public void queryForStudents(StudentDAO studentDAO) {

		// Get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// Display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

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

	public void queryForStudentsByLastName(StudentDAO studentDAO) {

		// Get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		// Display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

	}

	public void updateStudent(StudentDAO studentDAO) {

		// Retrieve student based on the id: Primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);

		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student...");

		// Change first name to "Scooby
		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);

		// Display updated student
		System.out.println("Updated student: " + myStudent);

	}

	public void deleteStudent(StudentDAO studentDAO) {
		int studentId = 6;

		System.out.println("Deleting student id: " + studentId);

		studentDAO.delete(studentId);
	}

	public void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

}
