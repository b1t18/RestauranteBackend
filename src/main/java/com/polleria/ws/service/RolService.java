package com.polleria.ws.service;

import java.util.List;

import com.polleria.ws.model.Rol;

public interface RolService 
{
	public List<Rol> findAll();
	public Rol findById(long idRol);
	public Rol save(Rol rol);
	public boolean deleteById(long idRol);
}
