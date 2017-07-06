package it.dstech.dao;

import java.util.List;

import it.dstech.model.Course;
import it.dstech.model.Student;

public interface CourseDao {

	public Course saveCourse(Course course);
	
	public Course readCourse(int id);
	
	public Boolean updateCourse(Course course);
	
	public List<Student> readCourseStudentFromCourse(int id);
	
	public Boolean removeStudent(int idStudent, int idCourse);
}
