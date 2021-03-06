package com.java.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.jwt.entities.User;
import com.java.jwt.interfaceServices.IUserService;
import com.java.jwt.services.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST})
public class UserController {
	
	@Autowired
	private IUserService userServiceCRUD;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public List<User> buscarTodo(){ 
		return userServiceCRUD.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User buscarXId(@PathVariable long id){
		return userServiceCRUD.findById(id);
	}
	
	@PostMapping("/user")
	public User Create(@RequestBody User user) {
		return userServiceCRUD.create(user);
	}
	
	@PostMapping("/user/pass")
	public User BuscarXUserPass(@RequestBody User user) {
		return (User) userService.loadUserByUsername(user.getUserName());
	}
	

}
