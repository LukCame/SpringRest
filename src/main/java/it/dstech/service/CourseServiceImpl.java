package it.dstech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.dao.CourseDao;
import it.dstech.model.Course;

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

}
