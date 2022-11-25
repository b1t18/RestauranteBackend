package com.polleria.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polleria.ws.model.Carta;

public interface CartaRepository extends JpaRepository<Carta, Long> {

}
