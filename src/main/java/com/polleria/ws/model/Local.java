package com.polleria.ws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Local 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLocal;
	private String nombre;
	private String direccion;
	private String hora;
	private String telefono;
	
	public Local()
	{
		
	}
	
	public Local(int idLocal, String nombre, String direccion, String hora, String telefono) 
	{
		super();
		this.idLocal = idLocal;
		this.nombre = nombre;
		this.direccion = direccion;
		this.hora = hora;
		this.telefono = telefono;
	}

	public int getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
}
