package org.example;

import java.util.Arrays;

import org.example.db.Author;
import org.example.db.AuthorDao;
import org.example.db.Movie;
import org.example.db.MovieDao;
import org.example.db.User;
import org.example.db.UserDao;

public class App
{

    public static void main( String[] args ) throws InterruptedException {
        Movie dummyTitle = new Movie();
        dummyTitle.setTitle("Dummy title");
        Movie przemineloZWiatrem = new Movie();
        przemineloZWiatrem.setTitle("Przeminelo z wiatrem");

        Author adamPusio = new Author("Adam", "Pusio", "Gdanska", dummyTitle);
        dummyTitle.setAuthor(adamPusio);
        Author adamKowalski = new Author("Adam", "Kowalski", "Gdanska", przemineloZWiatrem);
        przemineloZWiatrem.setAuthor(adamKowalski);

        User user = new User("Admin",
            "Gdanska",
            Arrays.asList(dummyTitle, przemineloZWiatrem));

        MovieDao movieDao = new MovieDao();
        AuthorDao authorDao = new AuthorDao();
        UserDao userDao = new UserDao();
        authorDao.save(adamPusio);
        authorDao.save(adamKowalski);
        movieDao.save(przemineloZWiatrem);
        movieDao.save(dummyTitle);
        userDao.save(user);

        authorDao.getAll().forEach(System.out::println);
        movieDao.getAll().forEach(System.out::println);
        userDao.getAll().forEach(System.out::println);

        Thread.sleep(2000L);
    }
}
