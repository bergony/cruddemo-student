package com.bergony.cruddemo;

import com.bergony.cruddemo.dao.StudentDAO;
import com.bergony.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
		//	create(studentDAO);
		//	createMultipleStudents(studentDAO);
		//	readStudent(studentDAO);
		//	queryForStudents(studentDAO);
		//	queryForStudentsByLastName(studentDAO);
			
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {

		int studentId =1 ;
		System.out.println("Getting student with id: "+studentId);

		Student student = studentDAO.findById(studentId);
		System.out.println("Updating student... ");

		student.setFirstName("Apoolo");
		student.setEmail("Apoolo@gmail.com");

		studentDAO.update(student);

		System.out.println("Updated Student:  "+student);



	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		List<Student> studentList = studentDAO.findByLastName("Duck");

		studentList.forEach( s -> {
			System.out.println(s);
		});
	}


	private void queryForStudents(StudentDAO studentDAO) {

		List<Student> studentList = studentDAO.findAll();

		studentList.forEach( s -> {
			System.out.println(s);
		});
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student objetc...");
		Student student = new Student("Daffy", "Duck", "Daffy@gmail.com");

		System.out.println("Saving the Student ...");
		studentDAO.save(student);

		System.out.println("Saved student, Generated-id "+ student.getId());

		System.out.println("Retrieving student with id: "+ student.getId());

		Student student1 = studentDAO.findById(student.getId());
		System.out.println("Found the Student: "+ student1);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student objetc...");
		Student student1 = new Student("bergony", "bandeira", "bergony@gmail.com");
		Student student2 = new Student("Jessica", "bandeira", "Jessica@gmail.com");
		Student student3 = new Student("Thrall", "bandeira", "Thrall@gmail.com");

		System.out.println("Saving the Student ...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

	}

	private void create(StudentDAO studentDAO) {

		System.out.println("Creating new student objetc...");
		Student student = new Student("bergony", "bandeira", "bergony@gmail.com");

		System.out.println("Saving the Student ...");
		studentDAO.save(student);

		System.out.println("Saved student, Generated-id"+ student.getId());

	}
}
