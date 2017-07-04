package it.dstech.dao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import it.dstech.model.Student;

public abstract class AbstractDao {

 @Autowired
 private SessionFactory sessionFactory;

 protected Session getSession() {
  return sessionFactory.getCurrentSession();
 }

 protected Object persist(Object obj) {
  getSession().persist(obj);
  return obj;
 }

 protected void delete(Object obj) {
  getSession().delete(obj);
 }

 protected Object update(Object obj) {
  getSession().update(obj);
  return obj;
 }
 
}