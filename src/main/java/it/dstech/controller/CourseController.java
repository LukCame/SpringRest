package it.dstech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.model.Course;
import it.dstech.model.Student;
import it.dstech.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService service;
	
	@PostMapping("/save")
	public ResponseEntity<Course> saveCourse(@RequestBody Course course){
		if(service.saveCourse(course)==null){
			return new ResponseEntity<Course>(HttpStatus.INTERNAL_SERVER_ERROR);
		}else{
			return new ResponseEntity<Course>(course,HttpStatus.OK);
		}
	}
	
	@GetMapping("/getModel")
	public Course getModel(){
		return new Course();
	}
}
