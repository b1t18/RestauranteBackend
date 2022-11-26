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

import com.polleria.ws.model.Rol;
import com.polleria.ws.service.RolService;

@RestController
@RequestMapping("/rol")
public class RolRestController 
{
	@Autowired
	private RolService rolService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarRoles()
	{
		try 
		{
			return ResponseEntity.status(HttpStatus.OK).body(rolService.findAll());
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@GetMapping("/listar/{idRoles}")
	public ResponseEntity<?> listarRol(@PathVariable long idRoles)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(rolService.findById(idRoles));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardarRol(@RequestBody Rol rol)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(rolService.save(rol));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@PutMapping("/actualizar/{idRoles}")
	public ResponseEntity<?> actualizar(@PathVariable long idRoles, @RequestBody Rol nuevoRol)
	{
		try
		{
			Rol antiguoRol = rolService.findById(idRoles);
			if (antiguoRol == null) return null;
			
			antiguoRol.setNombre(nuevoRol.getNombre());
			
			return ResponseEntity.status(HttpStatus.OK).body(rolService.save(antiguoRol));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@DeleteMapping("/eliminar/{idRoles}")
	public ResponseEntity<?> eliminarRol(@PathVariable long idRoles)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(rolService.deleteById(idRoles));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
}
