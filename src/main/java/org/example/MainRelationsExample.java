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
    private static ActroDao actorDao;
    private static EntityDao<Movie> movieDao;

    public static void main(String[] args) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        ReviewerDao reviewerDao = new ReviewerDao(hibernateFactory, Reviewer.class);
        EntityDao<Movie> movieDao = new EntityDao<>(hibernateFactory, Movie.class);
        EntityDao<Author> authorDao = new EntityDao<>(hibernateFactory, Author.class);
        ActroDao actorDao = new ActroDao(hibernateFactory);


        savingOneToOne(reviewerDao, movieDao);
        savingOneToMany(movieDao, authorDao);
        savingManyToMany(actorDao,movieDao);

        hibernateFactory.getSessionFactory().close();
    }

    private static void savingManyToMany(ActroDao actroDao, EntityDao<Movie> movieDao) {
        Actor michal = new Actor();
        michal.setName("Michal");
        michal.setSurname("Michalski");

        Actor bartek = new Actor();
        bartek.setName("Bartek");
        bartek.setSurname("Bartkowiak");

        Movie titanic2 = new Movie();
        titanic2.setTitle("Titanic II");

        Movie titanic3 = new Movie();
        titanic3.setTitle("Titanic III");

        titanic2.setActors(List.of(michal,bartek));

        actroDao.save(michal);
        actroDao.save(bartek);
        movieDao.save(titanic2);
        movieDao.save(titanic3);

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
