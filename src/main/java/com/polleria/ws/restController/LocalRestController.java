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

import com.polleria.ws.model.Local;
import com.polleria.ws.service.LocalService;

@RestController
@RequestMapping("/local")
public class LocalRestController 
{
	@Autowired
	public LocalService localService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarLocales()
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(localService.findAll());
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@GetMapping("/listar/{idLocal}")
	public ResponseEntity<?> listarLocal(@PathVariable long idLocal)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(localService.findById(idLocal));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardarLocal(@RequestBody Local local)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(localService.save(local));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@PutMapping("/actualizar/{idLocal}")
	public ResponseEntity<?> actualizarLocal(@PathVariable long idLocal, @RequestBody Local nuevoLocal)
	{
		try
		{
			Local antiguoLocal = localService.findById(idLocal);
			if (antiguoLocal == null) return null;
			
			antiguoLocal.setNombre(nuevoLocal.getNombre());
			antiguoLocal.setDireccion(nuevoLocal.getDireccion());
			antiguoLocal.setTelefono(nuevoLocal.getTelefono());
			antiguoLocal.setHora(nuevoLocal.getHora());
			
			return ResponseEntity.status(HttpStatus.OK).body(localService.save(antiguoLocal));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@DeleteMapping("/eliminar/{idLocal}")
	public ResponseEntity<?> eliminarLocal(@PathVariable long idLocal)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(localService.deleteById(idLocal));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
}
