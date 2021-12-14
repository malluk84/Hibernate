package org.example;

import org.example.dao.AuthorDao;
import org.example.dao.MovieDao;
import org.example.model.Movie;

import java.util.List;

public class HqlExample {
    public static void main(String[] args) throws InterruptedException {
        HibernateFactory hibernateFactory = new HibernateFactory();
        MovieDao movieDao = new MovieDao(hibernateFactory);
        AuthorDao authorDao = new AuthorDao(hibernateFactory);

        List<Movie> movies = movieDao.getAll();
        movies.forEach(System.out::println);
        authorDao.getAll().forEach(System.out::println);

        System.out.println("GET BY TITLE: ");
        movieDao.getByTitle("Psy").forEach(System.out::println);

        System.out.println("GET BY AGE: ");
        authorDao.getByAge(33).forEach(System.out::println);

        hibernateFactory.getSessionFactory().close();
        Thread.sleep(2000);
    }
}
