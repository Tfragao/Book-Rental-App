package com.taison.servlets.models;

import java.util.Objects;

public class Book {
	private Long id;
	private String title;
	private String auhtor;
	
	public Book(Long id, String title, String author) {
		setId(id);
		setAuhtor(author);
		setTitle(title);
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuhtor() {
		return auhtor;
	}

	public void setAuhtor(String auhtor) {
		this.auhtor = auhtor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(auhtor, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(auhtor, other.auhtor) && Objects.equals(id, other.id)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", auhtor=" + auhtor + "]";
	}
	
	
	
	
}
