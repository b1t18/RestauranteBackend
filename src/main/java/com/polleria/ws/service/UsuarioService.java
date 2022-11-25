package com.polleria.ws.service;

import java.util.List;

import com.polleria.ws.model.Usuario;

public interface UsuarioService 
{
	public List<Usuario> findAll();
	public Usuario findById(long nroUsuario);
	public void save(Usuario usuario);
	public void deleteLogic(Long nroUsuario);
	public void deleteDate(Long nroUsuario);
}
