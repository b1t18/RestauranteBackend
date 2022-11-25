package com.polleria.ws.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nroUsuario;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Column(length = 50, nullable = false)
	private String apellido;
	
	@Column(length = 8, nullable = false)
	private String dni;
	
	@Column(length = 50, nullable = false)
	private String correo;
	
	@Column(length = 50, nullable = false)
	private String direccion;
	
	@Column(length = 9, nullable = false)
	private String telefono;
	
	private Date fechaIngreso;
	
	@Column(nullable = false)
	private boolean estado;
	
	public Usuario() {
		
	}
	
	public Usuario(long nroUsuario, String nombre, String apellido, String dni, String correo, String direccion,
			String telefono, Date fechaIngreso, boolean estado) {
		this.nroUsuario = nroUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
	}

	public long getNroUsuario() {
		return nroUsuario;
	}

	public void setNroUsuario(long nroUsuario) {
		this.nroUsuario = nroUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
}

