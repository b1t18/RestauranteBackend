package com.polleria.ws.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polleria.ws.model.Login;
import com.polleria.ws.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginRestController 
{
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listasLogin()
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(loginService.findAll());
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@GetMapping("/listar/{idLogin}")
	public ResponseEntity<?> listarLogin(@PathVariable long idLogin)
	{
		try 
		{
			return ResponseEntity.status(HttpStatus.OK).body(loginService.findById(idLogin));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@GetMapping("/listar/{user}/{password}")
	public ResponseEntity<?> listarLogin(@PathVariable String user, @PathVariable String password)
	{
		try 
		{
			return ResponseEntity.status(HttpStatus.OK).body(loginService.findByUYP(user,password));
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> guardarLogin(@RequestBody Login login)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(loginService.save(login));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@PutMapping("/actualizar/{idLogin}")
	public ResponseEntity<?> actualizarLogin(@PathVariable long idLogin, @RequestBody Login nuevoLogin)
	{
		try
		{
			Login antiguoLogin = loginService.findById(idLogin);
			if (antiguoLogin == null) return null;
			
			antiguoLogin.setUser(nuevoLogin.getUser());
			antiguoLogin.setPassword(nuevoLogin.getPassword());
			
			return ResponseEntity.status(HttpStatus.OK).body(loginService.save(antiguoLogin));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
	
	@DeleteMapping("/eliminar/{idLogin}")
	public ResponseEntity<?> eliminarLogin(@PathVariable long idLogin)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(loginService.deleteById(idLogin));
		}
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ha ocurrido un error, por favor inténtelo de nuevo más tarde");
		}
	}
}
