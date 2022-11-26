package com.polleria.ws.service;

import java.util.List;

import com.polleria.ws.model.DetallePedido;

public interface DetallePedidoService 
{
	public List<DetallePedido> findAll();
	public DetallePedido findById(long nroDetallePedido);
	public DetallePedido save(DetallePedido detallePedido);
	public boolean deleteById(long nroDetallePedido);
}
