package com.polleria.ws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Login 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLogin;
	
	@OneToOne
	@JoinColumn(name = "nroUsuario")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name = "nroEmpleado")
	private Empleado empleado;
	
	private String user;
	private String password;
	
	public Login() {
		
	}

	public Login(long idLogin, Usuario usuario, Empleado empleado, String user, String password) {
		this.idLogin = idLogin;
		this.usuario = usuario;
		this.empleado = empleado;
		this.user = user;
		this.password = password;
	}

	public long getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(long idLogin) {
		this.idLogin = idLogin;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
