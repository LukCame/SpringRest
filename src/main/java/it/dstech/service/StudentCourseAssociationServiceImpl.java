package it.dstech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.dao.CourseDao;
import it.dstech.dao.StudentDao;
import it.dstech.model.Course;
import it.dstech.model.Student;

@Service
public class StudentCourseAssociationServiceImpl implements StudentCourseAssociationService {

	@Autowired
	StudentDao studDao;
	
	@Autowired
	CourseDao courseDao;

	@Override
	public Boolean associate(int idCorso, int idStudente) {
		try{
			Student stud=studDao.getStudentById(idStudente);
			Course course=courseDao.readCourse(idCorso);
			List<Student> students=new ArrayList<>();
			students.add(stud);
			course.setStudenti(students);
			courseDao.updateCourse(course);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
