package org.example.db;

import java.util.List;

import org.example.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthorDao {
	private HibernateFactory hibernateFactory = new HibernateFactory();

	public void save(Author author){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(author);
		transaction.commit();
		session.close();
	}

	public List<Author> getAll(){
		Session session = hibernateFactory.getSessionFactory().openSession();
		List<Author> authors = session.createQuery("From Author", Author.class).list();
		session.close();
		return authors;
	}

	public void update(Author author){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(author);
		transaction.commit();
		session.close();
	}

	public Author get(int id){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Author author = session.get(Author.class, id);
		session.close();
		return author;
	}

	public void delete(Author author){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(author);
		transaction.commit();
		session.close();
	}

	public void deletebyId(int id){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Author author = session.get(Author.class, id);
		session.delete(author);
		transaction.commit();
		session.close();
	}
}
