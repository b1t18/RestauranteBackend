package com.polleria.ws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DetallePedido 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nroDetalle;
	
	@OneToOne
	@JoinColumn(name = "nroPedido")
	private int nroPedido;
	private String nombre;
	private int cantidad;
	private double precio;
	
	public DetallePedido() {
		
	}
	
	public DetallePedido(int nroDetalle, int nroPedido, String nombre, int cantidad, double precio) 
	{
		super();
		this.nroDetalle = nroDetalle;
		this.nroPedido = nroPedido;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getNroDetalle() {
		return nroDetalle;
	}

	public void setNroDetalle(int nroDetalle) {
		this.nroDetalle = nroDetalle;
	}

	public int getNroPedido() {
		return nroPedido;
	}

	public void setNroPedido(int nroPedido) {
		this.nroPedido = nroPedido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
