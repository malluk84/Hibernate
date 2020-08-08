package org.example;

import java.util.Arrays;
import java.util.List;

import org.example.db.Author;
import org.example.db.AuthorDao;
import org.example.db.Badge;
import org.example.db.BadgeDao;
import org.example.db.Movie;
import org.example.db.MovieDao;
import org.example.db.User;
import org.example.db.UserDao;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class Main
{

    public static void main( String[] args ) throws InterruptedException {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
//        User user1 = session.get(User.class, 1);
//        user1.setLogin("HAHAHA");
//        Hibernate.initialize(user1.getMovies());
//        session.close();
//        List<Movie> movies = user1.getMovies();
//        for (Movie movie : movies) {
//            System.out.println(movie);
//        }

        UserDao userDao = new UserDao();
        List<User> all = session.createQuery("From User", User.class).list();
        for (User user : all) {
            System.out.println(user);
            List<Movie> movies = user.getMovies();
            for (Movie movie : movies) {
                System.out.println(movie);
            }

        }
        session.close();

        Thread.sleep(2000L);
    }
}
