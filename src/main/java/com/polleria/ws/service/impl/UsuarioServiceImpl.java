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
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);

	}

	@Override
	public boolean deleteLogic(Long nroUsuario) 
	{
		try
		{
			Usuario usu = findById(nroUsuario);
			if (usu == null) return false;
			usu.setEstado(false);
			usuarioRepository.save(usu);
			return true;
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	@Override
	public boolean deletePhysical(Long nroUsuario)
	{
		try
		{
			if (!usuarioRepository.existsById(nroUsuario)) return false;
			
			usuarioRepository.deleteById(nroUsuario);
			return true;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

}
