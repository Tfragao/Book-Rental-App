package com.taison.servlets.users.controllers;

import java.io.IOException;
import java.util.Properties;

import com.taison.servlets.dao.DaoException;
import com.taison.servlets.users.dao.DaoFactory;
import com.taison.servlets.users.dao.DaoUser;

public class Global {
	static final DaoUser DAO;
	private static final String CONFIGURATION = "configuration.properties";
	
	static {
		try {
				Properties props = new Properties();
				props.load(Global.class.getClassLoader().getResourceAsStream(CONFIGURATION));
				
				String type = props.getProperty("dao.daoType");
				
				DAO = new DaoFactory(type).getDaoUser();
		}catch(IOException e) {
			throw new DaoException("We could not get the settings");
		}
	}
}
