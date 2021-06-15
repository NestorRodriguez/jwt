package com.java.jwt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.jwt.entities.User;
import com.java.jwt.entities.InterfaceDAO.IUserDao;
import com.java.jwt.interfaceServices.IUserService;

@Service
public class UserServiceCRUD implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	@Override
	public User create(User user) {
		return userDao.save(user);
	}

	@Override
	public User findById(long id) {
		return userDao.findById(id).get();
	}

}
