package com.java.jwt.entities.InterfaceDAO;

import org.springframework.data.repository.CrudRepository;

import com.java.jwt.entities.User;

public interface IUserDao extends CrudRepository<User, Long>{
	
	public User findUserByUserPass(String user, String password);
	
	public User findUserByUsername(String user);
}
