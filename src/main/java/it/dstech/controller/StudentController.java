package it.dstech.controller;

import java.util.List;

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

import it.dstech.model.Course;
import it.dstech.model.Student;
import it.dstech.service.CourseService;
import it.dstech.service.StudentCourseAssociationService;
import it.dstech.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@Autowired
	private CourseService courseService;

	@Autowired
	private StudentCourseAssociationService serviceAss;

	@GetMapping("/getModel")
	public Student getModel() {
		return new Student();
	}

	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		try {
			Student saved = service.saveStudent(student);
			return new ResponseEntity<>(saved, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Student>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/update")
	public ResponseEntity<Boolean> updateStudent(@RequestBody Student student) {
		boolean outcome = service.updateStudent(student);
		if (outcome == true) {
			return new ResponseEntity<>(outcome, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(outcome, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteStudent(@PathVariable("id") int id) {
		boolean outcome = service.deleteStudent(id);
		if (outcome == true) {
			return new ResponseEntity<>(outcome, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(outcome, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete")
	public ResponseEntity<Boolean> deleteStudent2(@RequestHeader("id") int id) {
		boolean outcome = service.deleteStudent(id);
		System.out.println(id);
		if (outcome == true) {
			return new ResponseEntity<>(outcome, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(outcome, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/show")
	public ResponseEntity<List<Student>> showStudents() {
		try {
			List<Student> students = service.retrieveAllStudents();
			return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Student>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/read")
	public ResponseEntity<Student> readStudent(@RequestHeader("id") int id) {
		Student stud = service.getStudentById(id);
		if (stud == null) {
			return new ResponseEntity<Student>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Student>(stud, HttpStatus.OK);
		}
	}

	@GetMapping("/associateCourse")
	public ResponseEntity<Boolean> associate(@RequestHeader("idStudente") int idStudente,
			@RequestHeader("idCorso") int idCorso) {
		if (serviceAss.associate(idCorso, idStudente)) {
			return new ResponseEntity<Boolean>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/showCourses")
	public ResponseEntity<List<Course>> retrieveAllCourses(@RequestHeader("id") int idStudente) {
		try {
			return new ResponseEntity<List<Course>>(service.retrieveAllCourses(idStudente), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Course>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/deleteCourse")
	public ResponseEntity<?> removeCourse(@RequestHeader("idStudente") int idStudente,
			@RequestHeader("idCorso") int idCorso) {
		try {
			courseService.removeStudent(idStudente, idCorso);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
