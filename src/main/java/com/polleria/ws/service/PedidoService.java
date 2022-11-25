package com.polleria.ws.service;

import java.util.List;

import com.polleria.ws.model.Pedido;

public interface PedidoService {
	public List<Pedido> findAll();
	public Pedido findById(long nroPedido);
	public Pedido save(Pedido pedido);
	public Pedido deleteById(long nroPedido);
}
