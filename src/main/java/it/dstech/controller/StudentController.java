package it.dstech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		try{
			Student saved= service.saveStudent(student);
			return new ResponseEntity<>(saved,HttpStatus.CREATED);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<Student>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<Boolean> updateStudent(@RequestBody Student student){
		boolean outcome=service.updateStudent(student);
		if(outcome==true){
			return new ResponseEntity<>(outcome,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(outcome,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteStudent(@PathVariable("id") int id){
		boolean outcome = service.deleteStudent(id);
		if(outcome==true){
			return new ResponseEntity<>(outcome,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(outcome,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/delete")
	public ResponseEntity<Boolean> deleteStudent2(@RequestHeader("id") int id){
		boolean outcome = service.deleteStudent(id);
		System.out.println(id);
		if(outcome==true){
			return new ResponseEntity<>(outcome,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(outcome,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
