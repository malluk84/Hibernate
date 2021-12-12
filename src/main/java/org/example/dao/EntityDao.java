package org.example.dao;

import lombok.AllArgsConstructor;
import org.example.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@AllArgsConstructor
public class EntityDao <T>{
    private HibernateFactory hibernateFactory;

    public void save(T entity){
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }
}
