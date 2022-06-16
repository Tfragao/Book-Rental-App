package com.taison.servlets.users.dao;

import java.util.TreeMap;


import com.taison.servlets.models.User;

public class DaoUserMemory implements DaoUser {
	private static final TreeMap<Long, User> users = new TreeMap<>();
	
	static {
		users.put(1L, new User(1L, "first.user@gmail.com", "123"));
		users.put(2L, new User(2L, "second.user@gmail.com", "234"));
		users.put(3L, new User(3L, "third.user@gmail.com", "345"));
		users.put(4L, new User(4L, "fourth.user@gmail.com", "456"));
	}
	
	private DaoUserMemory() {
		
	}
	
	private static final DaoUserMemory INSTANCE = new DaoUserMemory();
	
	public static DaoUserMemory getUserInstance() {
		return INSTANCE;
	}

	@Override
	public Iterable<User> getAllUsers() {
		
		return users.values();
	}

	@Override
	public User getUsersById(Long id) {
		
		return users.get(id);
	}

	@Override
	public User insertUser(User user) {
		Long id = users.size() > 0 ? users.lastKey() + 1L : 1L;
		user.setId(id);
		users.put(user.getId(), user);
		return user;
	}

	@Override
	public User modifyUser(User user) {
		users.put(user.getId(), user);
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		
		users.remove(id);
	}
	
	
}
