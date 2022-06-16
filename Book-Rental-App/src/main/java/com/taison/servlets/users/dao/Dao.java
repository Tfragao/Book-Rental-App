package com.taison.servlets.users.dao;



public interface Dao<T> {
	
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
