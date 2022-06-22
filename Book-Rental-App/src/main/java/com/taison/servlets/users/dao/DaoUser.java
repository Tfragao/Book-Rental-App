package com.taison.servlets.users.dao;

import com.taison.servlets.dao.DaoException;
import com.taison.servlets.models.User;

public interface DaoUser extends Dao<User> {
	default User getByEmail(String email) {
		throw new DaoException("NOT IMPLEMENTED");
	}
}
