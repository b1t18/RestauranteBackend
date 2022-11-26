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

import com.polleria.ws.model.DetallePedido;
import com.polleria.ws.service.DetallePedidoService;

@RestController
@RequestMapping("/detallepedido")
public class DetallePedidoRestController 
{
	@Autowired
	private DetallePedidoService detallePedidoService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarDetallePedidos()
	{
		try 
		{
			return ResponseEntity.status(HttpStatus.OK).body(detallePedidoService.findAll());
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@GetMapping("/listar/{nroDetalle}")
	public ResponseEntity<?> listarDetallePedido(@PathVariable long nroDetalle)
	{
		try 
		{
			return ResponseEntity.status(HttpStatus.OK).body(detallePedidoService.findById(nroDetalle));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardarDetallePedido(@RequestBody DetallePedido detallePedido)
	{
		try 
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(detallePedidoService.save(detallePedido));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@PutMapping("/actualizar/{nroDetalle}")
	public ResponseEntity<?> actualizarDetallePedido(@PathVariable long nroDetalle, @RequestBody DetallePedido nuevoDetallePedido)
	{
		try 
		{
			DetallePedido antiguoDetallePedido = detallePedidoService.findById(nroDetalle);
			if (antiguoDetallePedido == null) return null;
			
			antiguoDetallePedido.setNombre(nuevoDetallePedido.getNombre());
			antiguoDetallePedido.setCantidad(nuevoDetallePedido.getCantidad());
			antiguoDetallePedido.setPrecio(nuevoDetallePedido.getPrecio());
			antiguoDetallePedido.setPedido(nuevoDetallePedido.getPedido());
			
			return ResponseEntity.status(HttpStatus.OK).body(detallePedidoService.save(antiguoDetallePedido));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}

	}
	
	@DeleteMapping("/eliminar/{nroDetalle}")
	public ResponseEntity<?> eliminarDetallePedido(@PathVariable long nroDetalle)
	{
		try 
		{
			return ResponseEntity.status(HttpStatus.OK).body(detallePedidoService.deleteById(nroDetalle));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
}
