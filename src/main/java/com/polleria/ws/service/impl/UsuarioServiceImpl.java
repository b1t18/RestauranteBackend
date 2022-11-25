package com.polleria.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polleria.ws.model.Usuario;
import com.polleria.ws.repository.UsuarioRepository;
import com.polleria.ws.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(long nroUsuario) {
		return usuarioRepository.findById(nroUsuario).orElse(null);
	}

	@Override
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);

	}

	@Override
	public void deleteLogic(Long nroUsuario) 
	{
		Usuario usu = findById(nroUsuario);
		if (usu == null) return;
		usu.setEstado(false);
		usuarioRepository.save(usu);
	}
	
	@Override
	public void deleteDate(Long nroUsuario)
	{
		usuarioRepository.deleteById(nroUsuario);
	}

}
