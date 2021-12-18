package org.example;

import org.example.dao.ActroDao;
import org.example.dao.EntityDao;
import org.example.dao.ReviewerDao;
import org.example.model.Actor;
import org.example.model.Author;
import org.example.model.Movie;
import org.example.model.Reviewer;

import java.util.List;

public class MainRelationsExample {
    public static void main(String[] args) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        ReviewerDao reviewerDao = new ReviewerDao(hibernateFactory, Reviewer.class);
        EntityDao<Movie> movieDao = new EntityDao<>(hibernateFactory, Movie.class);
        EntityDao<Author> authorDao = new EntityDao<>(hibernateFactory, Author.class);
        ActroDao actorDao = new ActroDao(hibernateFactory);


        savingOneToOne(reviewerDao, movieDao);
        savingOneToMany(movieDao, authorDao);

        hibernateFactory.getSessionFactory().close();
    }

    private static void savingOneToMany(EntityDao<Movie> movieDao, EntityDao<Author> authorDao) {
        Author author = new Author();
        author.setName("Some");
        author.setSurname("Crazy");

        Movie titanic = new Movie();
        titanic.setTitle("titanic");
        titanic.setAuthor(author);

        Movie psiPatrol = new Movie();
        psiPatrol.setTitle("pso patrol");
        psiPatrol.setAuthor(author);

        /*  author.setMovieList(List.of(titanic, psiPatrol));*/
        authorDao.save(author);
        movieDao.save(titanic);
        movieDao.save(psiPatrol);
    }

    private static void savingOneToOne(ReviewerDao reviewerDao, EntityDao<Movie> movieDao) {
        Movie sampleMovie = new Movie();
        sampleMovie.setTitle("Sample movie");
        sampleMovie.setProductionYear(1997);
        sampleMovie.setType("DRAMA");

        Reviewer reviewer = new Reviewer();
        reviewer.setName("Adam");
        reviewer.setSurname("Adamski");
        reviewer.setMovie(sampleMovie);

        movieDao.save(sampleMovie);
        reviewerDao.save(reviewer);
        Reviewer byId = reviewerDao.getById(reviewer.getId());
        System.out.println(byId);
    }
}
