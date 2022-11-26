package com.polleria.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polleria.ws.model.Login;
import com.polleria.ws.repository.LoginRepository;
import com.polleria.ws.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService
{
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public List<Login> findAll() {
		return loginRepository.findAll();
	}

	@Override
	public Login findById(long idLogin) {
		return loginRepository.findById(idLogin).orElse(null);
	}

	@Override
	public Login save(Login login) {
		return loginRepository.save(login);
	}

	@Override
	public boolean deleteById(long idLogin) 
	{
		try 
		{
			if (!loginRepository.existsById(idLogin)) return false;
			
			loginRepository.deleteById(idLogin);
			return true;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	@Override
	public Login findByUYP(String user, String password) {
		return loginRepository.findByUserAndPassword(user, password);
	}
}
