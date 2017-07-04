package it.dstech.service;

import it.dstech.model.Student;

public interface StudentService {

	public Student saveStudent(Student stud);
	
	public boolean updateStudent(Student stud);
	
	public boolean deleteStudent(int id);
	
}
