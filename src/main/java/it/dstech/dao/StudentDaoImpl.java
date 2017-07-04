package it.dstech.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import it.dstech.model.Student;

@Repository
@Transactional
public class StudentDaoImpl extends AbstractDao implements StudentDao {

	@Override
	public Student saveStudent(Student stud) {
		try{
			this.persist(stud);
			return stud;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
