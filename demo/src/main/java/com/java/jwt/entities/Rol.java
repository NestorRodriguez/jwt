package com.java.jwt.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Rol implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Atributos
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private long id;
	
	@Column(name="DESCRIPTION", nullable=false)
	private String  description;

	//Constructor
	public Rol() {
		super();
	}

	//Métodos
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", description=" + description + "]";
	}
	
	
}
