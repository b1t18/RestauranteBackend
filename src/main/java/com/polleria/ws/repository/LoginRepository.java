package com.polleria.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polleria.ws.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long>
{

}
