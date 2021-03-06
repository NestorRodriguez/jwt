package com.java.jwt.interfaceServices;

import java.util.List;

import com.java.jwt.entities.User;

public interface IUserService {

	public List<User> findAll();
	
	public User findById(long id);
	
	public User create(User user);
}
