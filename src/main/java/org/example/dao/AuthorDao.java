package org.example.dao;

import lombok.AllArgsConstructor;
import org.example.HibernateFactory;
import org.example.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@AllArgsConstructor
public class AuthorDao {
    private HibernateFactory hibernateFactory;

    public void add(Author author){
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(author);
        transaction.commit();
        session.close();
    }
}
