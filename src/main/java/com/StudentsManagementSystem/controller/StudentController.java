package com.StudentsManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.StudentsManagementSystem.entity.Student;
import com.StudentsManagementSystem.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
@Controller
public class StudentController {
	@Autowired
	private StudentService service;

	/*
	 * @GetMapping("/home")
	 * 
	 * public String home() { return "home"; // view page html file =>home.html }
	 */
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", service.getAllStudents());
		
		return "students";
	}
	//Student student = new Student(); // to hold the student data in this object 
	//Never use new object in controller as it's singleton will not work for multithreaded.
	@GetMapping("students/new")	
	public String CreateStudentForm(Model model) {
		model.addAttribute("student", new Student());
		
		return "create-student";
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/students")
	public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "create_student";
		}
		service.saveStudent(student);
		return "redirect:/students";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		model.addAttribute("student", service.getById(id));
		return "edit_student";
	}
	@PostMapping("/students/edit/{id}")
	public String UpdateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {
		Student existingStudent = service.getById(id);//student;// service.getById(id);
		
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		System.out.println("Updating student with id = " + student.getId());
		service.saveStudent(existingStudent);
		
		return  "redirect:/students";
	}
	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id) {
		
		service.deleteById(id);
		return  "redirect:/students";
	}
	
	
}
