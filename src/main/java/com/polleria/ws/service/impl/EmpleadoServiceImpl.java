package com.polleria.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polleria.ws.model.Empleado;
import com.polleria.ws.repository.EmpleadoRepository;
import com.polleria.ws.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService
{
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	
	@Override
	public List<Empleado> findAll() 
	{
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado findById(long nroEmpleado) 
	{
		return empleadoRepository.findById(nroEmpleado).orElse(null);
	}

	@Override
	public Empleado save(Empleado empleado)
	{	
		return empleadoRepository.save(empleado); 
	}

	@Override
	public Empleado delete(Long nroEmpleado) {
		Empleado empleado = findById(nroEmpleado);
		empleado.setEstado(false);
		return empleadoRepository.save(empleado);
	}

}
