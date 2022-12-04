package com.polleria.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polleria.ws.dto.CartaSinCaTDTO;
import com.polleria.ws.model.Carta;
import com.polleria.ws.repository.CartaRepository;
import com.polleria.ws.service.CartaService;

@Service
public class CartaServiceImpl implements CartaService
{
	@Autowired
	private CartaRepository cartaRepository;

	@Override
	public List<Carta> findAll() 
	{
		return cartaRepository.findAll();
	}

	@Override
	public Carta findById(long idCarta) 
	{
		try 
		{
			return cartaRepository.findById(idCarta).orElse(null);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public Carta save(Carta carta) 
	{
		return cartaRepository.save(carta);
	}

	@Override
	public boolean deleteById(long idCarta) 
	{
		
		try 
		{
			if (!cartaRepository.existsById(idCarta)) return false;
			
			cartaRepository.deleteById(idCarta);;
			return true;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	@Override
	public List<CartaSinCaTDTO> findByDTO(long idLocal)
	{
		List<Carta> cartaList = cartaRepository.findAllByLocalIdLocal(idLocal);
		
		List<CartaSinCaTDTO> lista = new ArrayList<>();
		CartaSinCaTDTO DTO = new CartaSinCaTDTO();
		
		for (Carta c : cartaList)
		{
			DTO.setIdCarta(c.getIdCarta());
			DTO.setNombrePlatillo(c.getNombrePlatillo());
			DTO.setImageRuta(c.getImageRuta());
			DTO.setPrecio(c.getPrecio());
			DTO.setDescripcion(c.getDescripcion());
			DTO.setIdLocal(idLocal);
			lista.add(DTO);
		}
		
		return lista;
	}
	
	
}
