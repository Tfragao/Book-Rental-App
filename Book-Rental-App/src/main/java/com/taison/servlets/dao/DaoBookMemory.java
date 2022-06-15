package com.taison.servlets.dao;

import java.util.TreeMap;

import com.taison.servlets.models.Book;

public class DaoBookMemory implements DaoBook {
	private static final TreeMap<Long, Book> books = new TreeMap<>();
	
	//Initial books in the store
	static {
		books.put(1L, new Book(1L, "Sea of Tranquility", "Emily St.John Mandel"));
		books.put(2L, new Book(2L, "The immortal King Rao", "Vauhini Vara"));
		books.put(3L, new Book(3L, "True Story: what reality TV says about us", "Danielle J. Lindemann"));
		books.put(4L, new Book(4L, "The candy house", "Jennifer Egan"));
	}
	
	//Singleton
	
	private DaoBookMemory() {
		
	}
	
	public static final DaoBookMemory INSTANCE = new DaoBookMemory();
	
	public static DaoBookMemory getInstance() {
		return INSTANCE;
	}

	@Override
	public Iterable<Book> getAllBooks() {
		
		return books.values();
	}

	@Override
	public Book getBooksById(Long id) {
		
		return books.get(id);
	}

	@Override
	public Book insert(Book book) {
		
		Long id = books.size() > 0 ? books.lastKey() + 1L : 1L;
		book.setId(id);
		books.put(book.getId(), book);
		return book;
	}

	@Override
	public Book modify(Book book) {
		books.put(book.getId(), book);
		return book;
	}

	@Override
	public void delete(Long id) {
		
		books.remove(id);
	}
	
	
	
	
}
