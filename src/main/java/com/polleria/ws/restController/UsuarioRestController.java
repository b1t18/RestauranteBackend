package com.polleria.ws.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polleria.ws.model.Usuario;
import com.polleria.ws.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController 
{
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/listar")
	public List<Usuario> listarUsuarios()
	{
		return usuarioService.findAll();
	}
	
	@GetMapping("/listar/{nroUsuario}")
	public Usuario listarUsuario(@PathVariable long nroUsuario)
	{
		return usuarioService.findById(nroUsuario);
	}
	
	@PostMapping("/guardar")
	public void guardarUsuario(@RequestBody Usuario usuario)
	{
		usuarioService.save(usuario);	
	}
	
	@DeleteMapping("/eliminar/{nroUsuario}")
	public void eliminarUsuario(@PathVariable long nroUsuario)
	{
		usuarioService.deleteLogic(nroUsuario);
	}
}
