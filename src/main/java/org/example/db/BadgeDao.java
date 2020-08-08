package org.example.db;

import java.util.List;

import org.example.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BadgeDao {
	private HibernateFactory hibernateFactory = new HibernateFactory();

	public void save(Badge badge){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(badge);
		transaction.commit();
		session.close();
	}

	public List<Badge> getAll(){
		Session session = hibernateFactory.getSessionFactory().openSession();
		List<Badge> badges = session.createQuery("From Badge", Badge.class).list();
		session.close();
		return badges;
	}

	public void update(Badge badge){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(badge);
		transaction.commit();
		session.close();
	}

	public Badge get(int id){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Badge badge = session.get(Badge.class, id);
		session.close();
		return badge;
	}

	public void delete(Badge badge){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(badge);
		transaction.commit();
		session.close();
	}

	public void deletebyId(int id){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Badge badge = session.get(Badge.class, id);
		session.delete(badge);
		transaction.commit();
		session.close();
	}
}
