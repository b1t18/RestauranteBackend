package com.polleria.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polleria.ws.model.DetallePedido;
import com.polleria.ws.repository.DetallePedidoRepository;
import com.polleria.ws.service.DetallePedidoService;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService 
{
	@Autowired
	private DetallePedidoRepository detallePedidoRepository;

	@Override
	public List<DetallePedido> findAll() 
	{
		return detallePedidoRepository.findAll();
	}

	@Override
	public DetallePedido findById(long nroDetallePedido) 
	{
		return detallePedidoRepository.findById(nroDetallePedido).orElse(null);
	}

	@Override
	public DetallePedido save(DetallePedido detallePedido) 
	{
		return detallePedidoRepository.save(detallePedido);
	}

	@Override
	public void deleteById(long nroDetallePedido) 
	{
		detallePedidoRepository.deleteById(nroDetallePedido);
	}
	
	
}
