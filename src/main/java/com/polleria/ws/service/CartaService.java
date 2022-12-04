package com.polleria.ws.service;

import java.util.List;

import com.polleria.ws.dto.CartaSinCaTDTO;
import com.polleria.ws.model.Carta;

public interface CartaService 
{
	public List<Carta> findAll();
	public Carta findById(long idCarta);
	public Carta save(Carta carta);
	public boolean deleteById(long idCarta);
	
	//public List<Carta> findById()
	
	public List<CartaSinCaTDTO> findByDTO(long idLocal);
}
