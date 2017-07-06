package it.dstech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.model.Course;
import it.dstech.model.Student;
import it.dstech.service.CourseService;
import it.dstech.service.StudentCourseAssociationService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService service;
	
	@Autowired
	private StudentCourseAssociationService serviceAss;
	
	@PostMapping("/save")
	public ResponseEntity<Course> saveCourse(@RequestBody Course course){
		if(service.saveCourse(course)==null){
			return new ResponseEntity<Course>(HttpStatus.INTERNAL_SERVER_ERROR);
		}else{
			return new ResponseEntity<Course>(course,HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/getModel")
	public Course getModel(){
		return new Course();
	}
	
	@GetMapping("/read")
	public ResponseEntity<Course> readCourse(@RequestHeader("id") int id){
		Course course = service.readCourse(id);
		if(course==null){
			return new ResponseEntity<Course>(HttpStatus.INTERNAL_SERVER_ERROR);
		}else{
			return new ResponseEntity<Course>(course,HttpStatus.OK);
		}
	}
	
	@GetMapping("/associateStudent")
	public ResponseEntity<Boolean> associate(@RequestHeader("idStudente") int idStudente,@RequestHeader("idCorso") int idCorso){
		if(serviceAss.associate(idCorso, idStudente)){
			return new ResponseEntity<Boolean>(HttpStatus.OK);
		}else{
			return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/showStudents")
	public ResponseEntity<List<Student>> retrieveAllStudent(@RequestHeader("id")int id){
		try{
			return new ResponseEntity<List<Student>>(service.retrieveAllStudents(id),HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<Student>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/deleteStudent")
	public ResponseEntity<?> removeStudent(@RequestHeader("idStudente") int idStudente,
			@RequestHeader("idCorso") int idCorso) {
		try {
			service.removeStudent(idStudente, idCorso);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
