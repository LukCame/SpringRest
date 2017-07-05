package it.dstech.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;



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
  getSession().merge(obj);
  return obj;
 }
 
 protected void associate2(Object obj){
	 getSession().save(obj);
 }
 
}