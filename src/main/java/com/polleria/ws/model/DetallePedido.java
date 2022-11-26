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
	private long nroDetalle;
	
	@OneToOne
	@JoinColumn(name = "nroPedido")
	private Pedido pedido;
	private String nombre;
	private int cantidad;
	private double precio;
	
	public DetallePedido() {
		
	}
	
	public DetallePedido(long nroDetalle, Pedido pedido, String nombre, int cantidad, double precio) 
	{
		super();
		this.nroDetalle = nroDetalle;
		this.pedido = pedido;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public long getNroDetalle() {
		return nroDetalle;
	}

	public void setNroDetalle(long nroDetalle) {
		this.nroDetalle = nroDetalle;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
