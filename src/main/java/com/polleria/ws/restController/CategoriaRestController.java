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

import com.polleria.ws.model.Categoria;
import com.polleria.ws.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaRestController 
{
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarCategorias()
	{
		try 
		{
			return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll());
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@GetMapping("/listar/{idCategoria}")
	public ResponseEntity<?> listarCategoria(@PathVariable long idCategoria)
	{
		try 
		{
			return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findById(idCategoria));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardarCategoria(@RequestBody Categoria categoria)
	{
		try 
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@PutMapping("/actualizar/{idCategoria}")
	public ResponseEntity<?> actualizarCategoria(@PathVariable long idCategoria, @RequestBody Categoria nuevaCategoria)
	{
		try 
		{
			Categoria antiguaCategoria = categoriaService.findById(idCategoria);
			if (antiguaCategoria == null) return null;
			
			antiguaCategoria.setNombre(nuevaCategoria.getNombre());
			antiguaCategoria.setDescripcion(nuevaCategoria.getDescripcion());
		
			return ResponseEntity.status(HttpStatus.OK).body(categoriaService.save(antiguaCategoria));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@DeleteMapping("/eliminar/{idCategoria}")
	public ResponseEntity<?> eliminarCategoria(@PathVariable long idCategoria)
	{
		try 
		{
			return ResponseEntity.status(HttpStatus.OK).body(categoriaService.deleteById(idCategoria));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
}
