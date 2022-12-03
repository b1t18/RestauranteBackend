package com.polleria.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polleria.ws.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>
{
	public Login findByUserAndPassword(String user, String password);
}
