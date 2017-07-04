package it.dstech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.model.Student;
import it.dstech.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/getModel")
	public Student getModel(){
		return new Student();
	}
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student){
		return service.saveStudent(student);
	}
	
}
