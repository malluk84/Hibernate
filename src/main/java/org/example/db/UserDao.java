package org.example.db;

import java.util.List;

import org.example.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {
	private HibernateFactory hibernateFactory = new HibernateFactory();

	public void save(User user){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
	}

	public List<User> getAll(){
		Session session = hibernateFactory.getSessionFactory().openSession();
		List<User> users = session.createQuery("From User", User.class).list();
		session.close();
		return users;
	}

	public void update(User user){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
		session.close();
	}

	public User get(int id){
		Session session = hibernateFactory.getSessionFactory().openSession();
		User user = session.get(User.class, id);
		session.close();
		return user;
	}

	public void delete(User user){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(user);
		transaction.commit();
		session.close();
	}

	public void deletebyId(int id){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		User user = session.get(User.class, id);
		session.delete(user);
		transaction.commit();
		session.close();
	}
}
