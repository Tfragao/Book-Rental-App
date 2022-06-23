package com.taison.servlets.dao;

public class DaoFactory {
	
	private DaoUser daoUser;
	
	public DaoFactory(String daoType) {
		switch(daoType) {
		case "memory":
			daoUser = DaoUserMemory.getUserInstance();
			break;
		case "exception":
			daoUser = new DaoUserException();
			break;
		default:
			throw new DaoException("type inknown" + daoType);
		}
	}
	
	public DaoUser getDaoUser() {
		return daoUser;
	}
}
