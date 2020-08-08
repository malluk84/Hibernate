package org.example.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private String address;

	@OneToOne(mappedBy = "author")
	private Movie movie;

	public Author() {
	}

	public Author(String name, String surname, String address, Movie movie) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.movie = movie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Author{" +
				   "id=" + id +
				   ", name='" + name + '\'' +
				   ", surname='" + surname + '\'' +
				   ", address='" + address + '\'' +
				  '}';
	}
}
