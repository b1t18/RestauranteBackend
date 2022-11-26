package com.polleria.ws.service;

import java.util.List;

import com.polleria.ws.model.Usuario;

public interface UsuarioService 
{
	public List<Usuario> findAll();
	public Usuario findById(long nroUsuario);
	public Usuario save(Usuario usuario);
	public boolean deleteLogic(Long nroUsuario);
	public boolean deletePhysical(Long nroUsuario);
}
