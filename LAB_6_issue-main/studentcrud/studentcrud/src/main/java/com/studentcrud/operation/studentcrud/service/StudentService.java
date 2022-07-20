package com.studentcrud.operation.studentcrud.service;
import java.util.List;

import com.studentcrud.operation.studentcrud.entity.Student;



public interface StudentService {

	public List<Student> searchAll();
	
	public Student searchById(int Id);
	//public void save (Student student);
	public void deleteById (int id);

	public void save(Student student);
	
}
