package it.dstech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.dao.CourseDao;
import it.dstech.model.Course;
import it.dstech.model.Student;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;
	
	@Override
	public Course saveCourse(Course course) {
		return courseDao.saveCourse(course);
	}

	@Override
	public Course readCourse(int id) {
		return courseDao.readCourse(id);
	}

	@Override
	public List<Student> retrieveAllStudents(int id) {
		return courseDao.readCourseStudentFromCourse(id);
	}

	@Override
	public Boolean removeStudent(int idStudent, int idCourse) {
		return courseDao.removeStudent(idStudent, idCourse);
	}


}
