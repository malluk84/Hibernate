package org.example;

import org.example.dao.AuthorDao;
import org.example.dao.MovieDao;
import org.example.model.Author;
import org.example.model.Movie;

import java.util.UUID;

public class App
{
    public static void main( String[] args ) throws InterruptedException {
//        System.out.println(UUID.randomUUID());
        HibernateFactory hibernateFactory = new HibernateFactory();
        MovieDao movieDao = new MovieDao(hibernateFactory);
        AuthorDao authorDao = new AuthorDao(hibernateFactory);

        Movie psy = new Movie();
        psy.setTitle("Psy");
        psy.setProductionYear(1992);
        psy.setTime(123342334);
        psy.setType("komedia");
        movieDao.add(psy);

        System.out.println("MOVIE FROM DB: " + movieDao.getById(1));

        Author kulfon = new Author();
        kulfon.setName("kulfon");
        kulfon.setSurname("kulfon");
        kulfon.setAge(33);
        kulfon.setNationality("Poland");
        authorDao.add(kulfon);

        hibernateFactory.getSessionFactory().close();
        Thread.sleep(2000);
    }
}
