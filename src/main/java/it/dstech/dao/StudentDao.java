package it.dstech.dao;

import java.util.List;

import it.dstech.model.Student;

public interface StudentDao {

	public Student saveStudent(Student stud);
	
	public boolean updateStudent(Student stud);
	
	public boolean deleteStudent(int id);
	
	public List<Student> retrieveAllStudents();
}
