package com.java.jwt.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.jwt.entities.Rol;
import com.java.jwt.entities.User;
import com.java.jwt.entities.InterfaceDAO.IUserDao;

@Service
public class UserService implements UserDetailsService{

	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private IUserDao userDao;


	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User usuario = userDao.findUserByUsername(username);
		if(usuario == null) {
			logger.error("Error en el login: El usuario '"+username+"'no existe en el sistema");
			throw new UsernameNotFoundException("Error en el login: El usuario '"+username+"'no existe en el sistema");
		}
		
		List<GrantedAuthority> autorities =  usuario.getRol()
				.stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getDescription()))
				.collect(Collectors.toList());
		
		return new  org.springframework.security.core.userdetails.User(usuario.getUserName(), usuario.getPassword(), true, true, true, true, autorities);
	}

}
