package it.dstech.service;

import it.dstech.model.Course;

public interface CourseService {
	
	public Course saveCourse(Course course);
	
	public Course readCourse(int id);
}
