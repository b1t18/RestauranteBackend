package com.polleria.ws.service;

import java.util.List;

import com.polleria.ws.model.Login;

public interface LoginService 
{
	public List<Login> findAll();
	public Login findById(long idLogin);
	public Login save(Login login);
	public void deleteById(long idLogin);
}
