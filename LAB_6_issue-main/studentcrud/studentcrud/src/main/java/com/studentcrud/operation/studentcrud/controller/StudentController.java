package com.studentcrud.operation.studentcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;

import com.studentcrud.operation.studentcrud.entity.Student;
import com.studentcrud.operation.studentcrud.service.StudentService;


@Controller 
@RequestMapping("/students")
public class StudentController implements ErrorController {

	@Autowired
	StudentService studentService;
	
	private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling";
    }

    public String getErrorPath() {
        return PATH;
    }
	
	@RequestMapping("/hello")
	public String sayhello(){
		System.out.println("We are in Hello");
		return "sayhello";
		//return "Welcome";
	}
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("Student", theStudent);

		return "form-Student";
	}
	@RequestMapping(value = "/printstudents", method = RequestMethod.GET)
	public String printStudents(Model theModel){
		System.out.println("Printing STudents");
		List<Student> students = studentService.searchAll();
		theModel.addAttribute("Students",students);
		return "list-Student";
	}
	@PostMapping("/saveForm")
	public String saveStudent(@RequestParam("id") int id,@RequestParam("firstName") String fname,  @RequestParam("lastName") String lname,
			@RequestParam("course") String course, @RequestParam("country") String country){
		//save the record into DB
		Student studentOBJ = new Student();
	
		
		Student theStudent;
		if(id!=0)
		{
			studentOBJ = studentService.searchById(id);
			studentOBJ.setFirstName(fname);
			studentOBJ.setLastName(lname);
			studentOBJ.setCourse(course);
			studentOBJ.setCountry(country);
			
		}
		else
			theStudent=new Student(fname, lname, course,country);
		// save the Book
		studentService.save(studentOBJ);
				
		//return to the list page
		return "redirect:/students/printstudents";
	}
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,
			Model theModel) {

		// get the Book from the service
		Student theStudent = studentService.searchById(theId);


		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Student", theStudent);

		// send over to our form
		return "form-Student";			
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		// delete the Book
		studentService.deleteById(theId);

		// redirect to /Books/list
		return "redirect:/students/printstudents";

	}
//	@PostMapping	
//	public String updateStudent(@RequestParam("firstName") String fname,  @RequestParam("lastName") String lname,
//			@RequestParam("course") String course, @RequestParam("country") String country) {
//		return "redirect/printstudents";
//	}
}
