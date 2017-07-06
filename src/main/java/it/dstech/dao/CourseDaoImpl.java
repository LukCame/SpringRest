package it.dstech.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
	
	@Autowired
	StudentDao studentDao;
	
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

	@Override
	public List<Student> readCourseStudentFromCourse(int id) {
		String hql="select s from Course c join c.studenti s where c.id=:id";
		Query query=getSession().createQuery(hql);
		query.setParameter("id", id);
		return (List<Student>) query.list();
	}
	
	public Boolean removeStudent(int idStudent,int idCorso){
		Course corso = readCourse(idCorso);
		Student student = studentDao.getStudentById(idStudent);
		corso.getStudenti().remove(student);
		update(corso);
		return true;
	}
	
	

}
