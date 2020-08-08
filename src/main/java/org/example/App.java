package org.example;

import java.util.Arrays;

import org.example.db.Author;
import org.example.db.AuthorDao;
import org.example.db.Badge;
import org.example.db.BadgeDao;
import org.example.db.Movie;
import org.example.db.MovieDao;
import org.example.db.User;
import org.example.db.UserDao;

public class App
{

    public static void main( String[] args ) throws InterruptedException {
        Badge cool = new Badge();
        cool.setName("Super");
        Badge bardzoSuper = new Badge();
        bardzoSuper.setName("Bardzo super");

        Movie dummyTitle = new Movie();
        dummyTitle.setTitle("Dummy title");
        Movie przemineloZWiatrem = new Movie();
        przemineloZWiatrem.setTitle("Przeminelo z wiatrem");
        przemineloZWiatrem.setBadges(
            Arrays.asList(cool, bardzoSuper)
        );
        cool.setMovies(Arrays.asList(przemineloZWiatrem));
        bardzoSuper.setMovies(Arrays.asList(przemineloZWiatrem));

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
        BadgeDao badgeDao = new BadgeDao();

        badgeDao.save(cool);
        badgeDao.save(bardzoSuper);
        authorDao.save(adamPusio);
        authorDao.save(adamKowalski);
        movieDao.save(przemineloZWiatrem);
        movieDao.save(dummyTitle);
        userDao.save(user);

        authorDao.getAll().forEach(System.out::println);
        movieDao.getAll().forEach(System.out::println);
        userDao.getAll().forEach(System.out::println);
        badgeDao.getAll().forEach(System.out::println);

        Thread.sleep(2000L);
    }
}
