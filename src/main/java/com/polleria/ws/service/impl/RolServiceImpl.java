package com.polleria.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polleria.ws.model.Rol;
import com.polleria.ws.repository.RolRepository;
import com.polleria.ws.service.RolService;

@Service
public class RolServiceImpl implements RolService
{
	
	@Autowired
	private RolRepository rolRepository;

	@Override
	public List<Rol> findAll() {
		return rolRepository.findAll();
	}

	@Override
	public Rol findById(long idRol) {
		return rolRepository.findById(idRol).orElse(null);
	}

	@Override
	public Rol save(Rol rol) 
	{
		return rolRepository.save(rol);
	}

	@Override
	public boolean deleteById(long idRol) 
	{
		try
		{
			if (!rolRepository.existsById(idRol)) return false;
			
			rolRepository.deleteById(idRol);
			return true;
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	

}
