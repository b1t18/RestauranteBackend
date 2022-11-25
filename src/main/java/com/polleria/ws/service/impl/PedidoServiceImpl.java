package com.polleria.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polleria.ws.model.Pedido;
import com.polleria.ws.repository.PedidoRepository;
import com.polleria.ws.service.PedidoService;


@Service
public class PedidoServiceImpl implements PedidoService 
{
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	@Override
	public Pedido findById(long nroPedido) {
		return pedidoRepository.findById(nroPedido).orElse(null);
	}

	@Override
	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	public Pedido deleteById(long nroPedido) 
	{	
		Pedido pedido = findById(nroPedido);
		pedido.setEstado(false);
		return pedido;
	}
	
	

}
