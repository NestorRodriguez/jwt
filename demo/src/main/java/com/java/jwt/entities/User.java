package com.java.jwt.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries(value= {
	@NamedQuery(name="User.findUserByUserPass", query="SELECT us FROM User us where us.userName = :user and us.password = :password"), 
	@NamedQuery(name="User.findUserByUsername",	query="SELECT us FROM User us where us.userName = :user")	
	}
)

@Entity
@Table(name="users")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private long id;
	
	@Column(name="USER_NAME", unique=true)
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Rol> rol;

	public User() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Rol> getRol() {
		return rol;
	}

	public void setRol(List<Rol> rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", rol=" + rol + "]";
	}
	
}
