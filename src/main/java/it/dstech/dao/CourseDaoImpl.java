package it.dstech.dao;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.dstech.model.Course;
import it.dstech.model.Student;

@Transactional
@Repository
public class CourseDaoImpl extends AbstractDao implements CourseDao {
	
	@Autowired
	CourseDao courseDao;
	
	@Override
	public Course saveCourse(Course course) {
		try{
			this.persist(course);
			return course;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Course readCourse(int id) {
		try{
			Criteria critiria=getSession().createCriteria(Course.class);
			critiria.add(Restrictions.eq("id",id));
			return (Course)critiria.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Boolean updateCourse(Course course) {
		try{
			this.update(course);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	
	

}
