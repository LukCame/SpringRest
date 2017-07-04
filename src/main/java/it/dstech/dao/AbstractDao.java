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

 protected void persist(Object obj) {
  getSession().persist(obj);
 }

 protected void delete(Object obj) {
  getSession().delete(obj);
 }

 protected void update(Object obj) {
  getSession().update(obj);
 }

}