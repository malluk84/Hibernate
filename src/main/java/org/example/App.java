package org.example;

import org.example.dao.MovieDao;
import org.example.model.Movie;

import java.util.UUID;

public class App
{
    public static void main( String[] args ) {
//        System.out.println(UUID.randomUUID());
        HibernateFactory hibernateFactory = new HibernateFactory();
        MovieDao movieDao = new MovieDao(hibernateFactory);

        Movie psy = new Movie();
        psy.setTitle("Psy");
        psy.setProductionYear(1992);
        psy.setTime(123342334);
        psy.setType("komedia");
        movieDao.add(psy);



        hibernateFactory.getSessionFactory().close();
    }
}
