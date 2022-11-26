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

import com.polleria.ws.model.Pedido;
import com.polleria.ws.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoRestController 
{
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarPedidos()
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findAll());
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@GetMapping("/listar/{nroPedido}")
	public ResponseEntity<?> listarPedido(@PathVariable long nroPedido)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findById(nroPedido));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardarPedido(@RequestBody Pedido pedido)
	{
		try 
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedido));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@PutMapping("/actualizar/{nroPedido}")
	public ResponseEntity<?> actualizarPedido(@PathVariable long nroPedido, @RequestBody Pedido nuevoPedido)
	{
		try
		{
			Pedido antiguoPedido = pedidoService.findById(nroPedido);
			if(antiguoPedido == null) return null;
			
			antiguoPedido.setPrecioTotal(nuevoPedido.getPrecioTotal());
			antiguoPedido.setTipoPago(nuevoPedido.getTipoPago());
			antiguoPedido.setMetodoPago(nuevoPedido.getMetodoPago());
			antiguoPedido.setEstado(nuevoPedido.getEstado());
			
			return ResponseEntity.status(HttpStatus.OK).body(pedidoService.save(antiguoPedido));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@DeleteMapping("/eliminar/{nroPedido}")
	public ResponseEntity<?> eliminarPedido(@PathVariable long nroPedido)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(pedidoService.deleteById(nroPedido));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
}
