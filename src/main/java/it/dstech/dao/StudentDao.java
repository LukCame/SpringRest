package it.dstech.dao;

import java.util.List;

import it.dstech.model.Course;
import it.dstech.model.Student;

public interface StudentDao {

	public Student saveStudent(Student stud);
	
	public boolean updateStudent(Student stud);
	
	public boolean deleteStudent(int id);
	
	public List<Student> retrieveAllStudents();
	
	public Student getStudentById(int id);
	
	public List<Course> readCoursesFromStudent(int id);
	
	public Boolean removeCourse(int idStudent,int idCourse);
}
