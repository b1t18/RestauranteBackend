package com.polleria.ws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Carta 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCarta;
	private String nombrePlatillo;
	private double precio;
	private String descripcion;
	
	@OneToOne
	@JoinColumn(name = "idCategoria")
	private Categoria categoria;
	
	@OneToOne
	@JoinColumn(name = "idLocal")
	private Local local;
	
	public Carta() {
	
	}

	public Carta(long idCarta, String nombrePlatillo, double precio, String descripcion, Categoria categoria,
			Local local) {
		super();
		this.idCarta = idCarta;
		this.nombrePlatillo = nombrePlatillo;
		this.precio = precio;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.local = local;
	}

	public long getIdCarta() {
		return idCarta;
	}

	public void setIdCarta(long idCarta) {
		this.idCarta = idCarta;
	}

	public String getNombrePlatillo() {
		return nombrePlatillo;
	}

	public void setNombrePlatillo(String nombrePlatillo) {
		this.nombrePlatillo = nombrePlatillo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
	
}
