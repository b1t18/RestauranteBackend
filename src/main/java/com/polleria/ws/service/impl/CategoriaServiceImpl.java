package com.polleria.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polleria.ws.model.Categoria;
import com.polleria.ws.repository.CategoriaRepository;
import com.polleria.ws.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> findAll() 
	{
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria findById(long idCategoria) 
	{
		return categoriaRepository.findById(idCategoria).orElse(null);
	}

	@Override
	public Categoria save(Categoria categoria) 
	{
		return categoriaRepository.save(categoria);
	}

	@Override
	public boolean deleteById(long idCategoria) 
	{
		try
		{
			if (!categoriaRepository.existsById(idCategoria)) return false;
			
			categoriaRepository.deleteById(idCategoria);
			return true;
		}
		catch (Exception e)
		{
			throw e;
		}
	}
}
