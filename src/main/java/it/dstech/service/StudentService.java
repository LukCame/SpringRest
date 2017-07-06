package it.dstech.service;

import java.util.List;

import it.dstech.model.Course;
import it.dstech.model.Student;

public interface StudentService {

	public Student saveStudent(Student stud);
	
	public boolean updateStudent(Student stud);
	
	public boolean deleteStudent(int id);
	
	public List<Student> retrieveAllStudents();
	
	public Student getStudentById(int id);
	
	public List<Course> retrieveAllCourses(int id);
	
	public Boolean removeCourse(int idStudente,int idCorso);
}
