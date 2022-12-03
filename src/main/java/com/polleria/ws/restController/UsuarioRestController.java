package com.polleria.ws.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polleria.ws.model.Usuario;
import com.polleria.ws.service.UsuarioService;
import com.polleria.ws.util.Utilitario;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController 
{
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarUsuarios()
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@GetMapping("/listar/{nroUsuario}")
	public ResponseEntity<?> listarUsuario(@PathVariable long nroUsuario)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(nroUsuario));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardarUsuario(@RequestBody Usuario usuario)
	{
		try
		{
			usuario.setFechaIngreso(new Utilitario().obtenerFechaActual());
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@PutMapping("/actualizar/{nroUsuario}")
	public ResponseEntity<?> actualizarUsuario(@PathVariable long nroUsuario, @RequestBody Usuario nuevoUsuario)
	{
		Usuario antiguoUsuario = usuarioService.findById(nroUsuario);
		if (antiguoUsuario == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		antiguoUsuario.setNombre(nuevoUsuario.getNombre());
		antiguoUsuario.setApellido(nuevoUsuario.getApellido());
		antiguoUsuario.setDni(nuevoUsuario.getDni());
		antiguoUsuario.setCorreo(nuevoUsuario.getCorreo());
		antiguoUsuario.setDireccion(nuevoUsuario.getDireccion());
		antiguoUsuario.setTelefono(nuevoUsuario.getTelefono());
		antiguoUsuario.setFechaIngreso(nuevoUsuario.getFechaIngreso());
		
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(antiguoUsuario));
	}
	
	@DeleteMapping("/eliminar/{nroUsuario}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable long nroUsuario)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(usuarioService.deleteLogic(nroUsuario));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
}
