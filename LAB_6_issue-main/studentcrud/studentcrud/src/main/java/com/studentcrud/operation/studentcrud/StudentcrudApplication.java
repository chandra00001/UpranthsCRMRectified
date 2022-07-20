package com.studentcrud.operation.studentcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//scanBasePackages = {"com.my.package","com.my.package.mylibrary"}
@SpringBootApplication(scanBasePackages = {"com.studentcrud.operation.*","com.studentcrud.operation.controller","com.studentcrud.operation.service","com.studentcrud.operation.entity","com.studentcrud.operation.repository"})
public class StudentcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentcrudApplication.class, args);
		System.out.println("SpringBoot initiated");
	}

}
