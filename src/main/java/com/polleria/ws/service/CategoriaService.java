package com.polleria.ws.service;

import java.util.List;

import com.polleria.ws.model.Categoria;

public interface CategoriaService 
{
	public List<Categoria> findAll();
	public Categoria findById(long idCategoria);
	public Categoria save(Categoria categoria);
	public void deleteById(long idCategoria);
}
