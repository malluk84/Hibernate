package org.example.db;

import java.util.List;

import org.example.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MovieDao {
	private HibernateFactory hibernateFactory = new HibernateFactory();

	public void save(Movie movie){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(movie);
		transaction.commit();
		session.close();
	}

	public List<Movie> getAll(){
		Session session = hibernateFactory.getSessionFactory().openSession();
		List<Movie> movies = session.createQuery("From Movie", Movie.class).list();
		session.close();
		return movies;
	}

	public void update(Movie movie){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(movie);
		transaction.commit();
		session.close();
	}

	public Movie get(int id){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Movie movie = session.get(Movie.class, id);
		session.close();
		return movie;
	}

	public void delete(Movie movie){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(movie);
		transaction.commit();
		session.close();
	}

	public void deletebyId(int id){
		Session session = hibernateFactory.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Movie movie = session.get(Movie.class, id);
		session.delete(movie);
		transaction.commit();
		session.close();
	}
}
