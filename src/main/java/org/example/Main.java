package org.example;

import org.example.dao.EntityDao;
import org.example.model.Movie;

public class Main {

    public static void main(String[] args) {

        EntityDao<Movie> movieEntityDao = new EntityDao<>(new HibernateFactory(), Movie.class);

        Movie movie = new Movie();
        movie.setTitle("Jakis Film");
        movieEntityDao.save(movie);

        System.out.println(movie);

    }
}
