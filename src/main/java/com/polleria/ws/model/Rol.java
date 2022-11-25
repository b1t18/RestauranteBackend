package com.polleria.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Rol")
public class Rol 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRoles;
	@Column(length = 50, nullable = false)
	private String nombre;
	
	public Rol(){
		
	}
	
	public Rol(long idRoles, String nombre) {
		super();
		this.idRoles = idRoles;
		this.nombre = nombre;
	}

	public long getIdRoles() {
		return idRoles;
	}

	public void setIdRoles(long idRoles) {
		this.idRoles = idRoles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
