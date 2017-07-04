package it.dstech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.dao.StudentDao;
import it.dstech.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;

	@Override
	public Student saveStudent(Student stud) {
		return studentDao.saveStudent(stud);
	}

	@Override
	public boolean updateStudent(Student stud) {
		return studentDao.updateStudent(stud);
	}

	@Override
	public boolean deleteStudent(int id) {
		return studentDao.deleteStudent(id);
	}

	
}
