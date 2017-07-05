package it.dstech.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import it.dstech.model.Student;

@Repository
@Transactional
public class StudentDaoImpl extends AbstractDao implements StudentDao {

	@Override
	public Student saveStudent(Student stud) {
		return (Student) this.persist(stud);
	}

	@Override
	public boolean updateStudent(Student stud) {
		try{
			this.update(stud);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public Student getStudentById(int id){
		try{
			Criteria critiria=getSession().createCriteria(Student.class);
			critiria.add(Restrictions.eq("id",id));
			return (Student) critiria.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteStudent(int id) {
		try{
			Student student=getStudentById(id);
			this.delete(student);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Student> retrieveAllStudents(){
		String hql="select s from Student s";
		Query query = getSession().createQuery(hql);
		return (List<Student>) query.list();
	}


}
