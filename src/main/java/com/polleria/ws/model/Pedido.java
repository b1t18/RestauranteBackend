package com.polleria.ws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pedido 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nroPedido;
	private double precioTotal;
	private String tipoPago;
	private String MetodoPago;
	private boolean estado;
	
	@OneToOne
	@JoinColumn(name = "idLocal")
	private Local local;
	
	public Pedido() {
		
	}

	public Pedido(int nroPedido, double precioTotal, String tipoPago, String metodoPago, Local local, boolean estado) 
	{
		super();
		this.nroPedido = nroPedido;
		this.precioTotal = precioTotal;
		this.tipoPago = tipoPago;
		MetodoPago = metodoPago;
		this.local = local;
		this.estado = estado;
	}

	public int getNroPedido() {
		return nroPedido;
	}

	public void setNroPedido(int nroPedido) {
		this.nroPedido = nroPedido;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getMetodoPago() {
		return MetodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		MetodoPago = metodoPago;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
