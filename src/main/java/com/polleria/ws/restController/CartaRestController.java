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

import com.polleria.ws.model.Carta;
import com.polleria.ws.service.CartaService;

@RestController
@RequestMapping("/carta")
public class CartaRestController {
	
	@Autowired
	private CartaService cartaService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarCartas()
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(cartaService.findAll());
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@GetMapping("/listar/{idCarta}")
	public ResponseEntity<?> listarCarta(@PathVariable long idCarta)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(cartaService.findById(idCarta));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardarCarta(@RequestBody Carta carta)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(cartaService.save(carta));
		}
		catch (Exception e) 
		{
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@PutMapping("/actualizar/{idCarta}")
	public ResponseEntity<?> actualizarCarta(@PathVariable long idCarta, @RequestBody Carta nuevaCarta)
	{
		try 
		{
			Carta antiguaCarta = cartaService.findById(idCarta);
			if (antiguaCarta == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
			antiguaCarta.setNombrePlatillo(nuevaCarta.getNombrePlatillo());
			antiguaCarta.setCategoria(nuevaCarta.getCategoria());
			antiguaCarta.setDescripcion(nuevaCarta.getDescripcion());
			antiguaCarta.setPrecio(nuevaCarta.getPrecio());
			antiguaCarta.setLocal(nuevaCarta.getLocal());
			return ResponseEntity.status(HttpStatus.OK).body(cartaService.save(antiguaCarta));
		}
		catch (Exception e) 
		{
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
		
	}
	
	@DeleteMapping("/eliminar/{idCarta}")
	public ResponseEntity<?> eliminarCarta(@PathVariable long idCarta)
	{
		try 
		{
			return ResponseEntity.status(HttpStatus.OK).body(cartaService.deleteById(idCarta));
		}
		catch (Exception e) 
		{
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
		
	}
}
