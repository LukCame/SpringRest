package it.dstech.service;

import java.util.List;

import it.dstech.model.Course;
import it.dstech.model.Student;

public interface CourseService {
	
	public Course saveCourse(Course course);
	
	public Course readCourse(int id);
	
	public List<Student> retrieveAllStudents(int id);
	
	public Boolean removeStudent(int idStudent, int idCourse);
}
