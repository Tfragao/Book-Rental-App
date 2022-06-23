package com.taison.servlets.dao;



public interface Dao<T> {
	default Iterable<T> getAllBooks() {
		throw new DaoException("NOT IMPLEMENTED");
	}
	
	default T getBooksById(Long id) {
		throw new DaoException("NOT IMPLEMENTED");
	}
	
	default T insert(T book) {
		throw new DaoException("NOT IMPLEMENTED");
	}
	
	default T modify(T book) {
		throw new DaoException("NOT IMPLEMENTED");
	}
	
	default void delete(Long id) {
		throw new DaoException("NOT IMPLMENTED");
	}
	
	default Iterable<T> getAllUsers() {
		throw new DaoException("NOT IMPLEMENTED");
	}
	
	default T getUsersById(Long id) {
		throw new DaoException("NOT IMPLEMENTED");
	}
	
	default T insertUser(T user) {
		throw new DaoException("NOT IMPLEMENTED");
	}
	
	default T modifyUser(T user) {
		throw new DaoException("NOT IMPLEMENTED");
	}
	
	default void deleteUser(Long id) {
		throw new DaoException("NOT IMPLEMENTED");
	}
}
