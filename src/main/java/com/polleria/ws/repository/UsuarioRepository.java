package com.polleria.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.polleria.ws.model.Usuario;

//@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
	//public Usuario findByUsuarioAndContrasenia();
}
