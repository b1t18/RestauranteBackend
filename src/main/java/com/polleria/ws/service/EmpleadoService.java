package com.polleria.ws.service;

import java.util.List;

import com.polleria.ws.model.Empleado;

public interface EmpleadoService 
{
	public List<Empleado> findAll();
	public Empleado findById(long nroEmpleado);
	public Empleado save(Empleado empleado);
	public Empleado delete(Long nroEmpleado);
}
