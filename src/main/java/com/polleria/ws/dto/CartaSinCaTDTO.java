package com.polleria.ws.dto;

public class CartaSinCaTDTO 
{
	private long idCarta;
	private String nombrePlatillo;
	private String imageRuta;
	private double precio;
	private String descripcion;
	private long idLocal;
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
	public long getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(long idLocal) {
		this.idLocal = idLocal;
	}
	public String getImageRuta() {
		return imageRuta;
	}
	public void setImageRuta(String imageRuta) {
		this.imageRuta = imageRuta;
	}
	
	
}
