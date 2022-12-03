package com.polleria.ws.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Empleado 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nroEmpleado;
	@Column(length = 50, nullable = false)
	private String nombre;
	@Column(length = 50, nullable = false)
	private String apellido;
	
	private Date fechaNacimiento;
	@Column(length = 50, nullable = false)
	private String correo;
	@Column(length = 8, nullable = false)
	private String dni;
	@Column(length = 9, nullable = false)
	private String telefono;
	@Column(length = 50, nullable = false)
	private String direccion;
	
	private Date fechaIngreso;
	private double salario;
	private boolean estado;
	
	@OneToOne
	@JoinColumn(name = "idRol")
	private Rol rol;
	
	@OneToOne
	@JoinColumn(name = "idLocal")
	private Local local;
	
	@OneToOne
	@JoinColumn(name = "idLogin")
	private Login login;

	public Empleado(){
		
	}
	
	public Empleado(long nroEmpleado, String nombre, String apellido, Date fechaNacimiento, String correo, String dni,
			String telefono, String direccion, Date fechaIngreso, double salario, boolean estado, Rol rol, Local local, Login login) {
		this.nroEmpleado = nroEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
		this.dni = dni;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechaIngreso = fechaIngreso;
		this.salario = salario;
		this.estado = estado;
		this.rol = rol;
		this.local = local;
		this.login = login;
	}

	
	
	public long getNroEmpleado() {
		return nroEmpleado;
	}


	public void setNroEmpleado(long nroEmpleado) {
		this.nroEmpleado = nroEmpleado;
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


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public boolean getEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	public Local getLocal() {
		return local;
	}


	public void setLocal(Local local) {
		this.local = local;
	}
	
	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}

}
