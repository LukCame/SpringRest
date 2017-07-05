package it.dstech.dao;

import it.dstech.model.Course;

public interface CourseDao {

	public Course saveCourse(Course course);
	
	public Course readCourse(int id);
	
	public Boolean updateCourse(Course course);
	
}
