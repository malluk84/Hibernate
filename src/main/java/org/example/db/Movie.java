package org.example.db;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;

	@OneToOne
	private Author author;

	@ManyToOne
	private User user;
	
	@ManyToMany
	private List<Badge> badges;

	public Movie() {
	}

	public Movie(String title, Author author, User user, List<Badge> badges) {
		this.title = title;
		this.author = author;
		this.user = user;
		this.badges = badges;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Badge> getBadges() {
		return badges;
	}

	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}

	@Override
	public String toString() {
		return "Movie{" +
				   "id=" + id +
				   ", title='" + title + '\'' +
				   ", author=" + (author == null ? "" : author.getName()) +
				   '}';
	}
}
