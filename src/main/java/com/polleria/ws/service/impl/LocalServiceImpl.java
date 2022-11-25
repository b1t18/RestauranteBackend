package com.polleria.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polleria.ws.model.Local;
import com.polleria.ws.repository.LocalRepository;
import com.polleria.ws.service.LocalService;

@Service
public class LocalServiceImpl implements LocalService 
{
	@Autowired
	private LocalRepository localRepository;

	@Override
	public List<Local> findAll() {
		return localRepository.findAll();
	}

	@Override
	public Local findById(Long idLocal) {
		return localRepository.findById(idLocal).orElse(null);
	}

	@Override
	public Local save(Local local) {
		return localRepository.save(local);
	}

	@Override
	public void deleteById(long idLocal) {
		localRepository.deleteById(idLocal);
	}
	
	
}
