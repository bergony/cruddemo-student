package com.bergony.cruddemo;

import com.bergony.cruddemo.dao.StudentDAO;
import com.bergony.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			create(studentDAO);
		};
	}

	private void create(StudentDAO studentDAO) {

		System.out.println("Creating new student objetc...");
		Student student = new Student("bergony", "bandeira", "bergony@gmail.com");

		System.out.println("Saving the Student ...");
		studentDAO.save(student);

		System.out.println("Saved student, Generated-id"+ student.getId());

	}
}
