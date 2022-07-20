package com.studentcrud.operation.studentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentcrud.operation.studentcrud.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findByFirstName(String name);

}
