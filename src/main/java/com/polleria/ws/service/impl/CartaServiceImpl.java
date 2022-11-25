package com.polleria.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polleria.ws.model.Carta;
import com.polleria.ws.repository.CartaRepository;
import com.polleria.ws.service.CartaService;

@Service
public class CartaServiceImpl implements CartaService
{
	@Autowired
	private CartaRepository cartaRepository;

	@Override
	public List<Carta> findAll() {
		return cartaRepository.findAll();
	}

	@Override
	public Carta findById(long idCarta) {
		return cartaRepository.findById(idCarta).orElse(null);
	}

	@Override
	public Carta save(Carta carta) 
	{
		return cartaRepository.save(carta);
	}

	@Override
	public void deleteById(long idCarta) 
	{
		cartaRepository.deleteById(idCarta);;
	}
	
	
}
