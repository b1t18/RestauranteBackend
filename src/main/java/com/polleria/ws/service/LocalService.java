package com.polleria.ws.service;

import java.util.List;

import com.polleria.ws.model.Local;

public interface LocalService {
	public List<Local> findAll();
	public Local findById(Long idLocal);
	public Local save(Local local);
	public void deleteById(long idLocal);
}
