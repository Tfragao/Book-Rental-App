package com.taison.servlets.dao;

import com.taison.servlets.models.User;

public interface DaoUser extends Dao<User> {
	default User getByEmail(String email) {
		throw new DaoException("NOT IMPLEMENTED");
	}
}
