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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.polleria.ws.model.Empleado;
import com.polleria.ws.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoRestController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/listar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> listarEmpleados()
	{
		List<Empleado> listaEmpleado = empleadoService.findAll();
		if (listaEmpleado == null)
			return new ResponseEntity<>("Aún no hay datos!", HttpStatus.OK);
		
		return new ResponseEntity<>(listaEmpleado, HttpStatus.OK);
	}
	
	@GetMapping("/listar/{nroEmpleado}")
	public ResponseEntity<?> listarEmpleado(@PathVariable long nroEmpleado)
	{
		Empleado empleado = empleadoService.findById(nroEmpleado);
		if (empleado == null)
			return new ResponseEntity<>("No se ha encontrado", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(empleado, HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	@ResponseStatus(HttpStatus.CREATED)
	public void guardarEmpleado(@RequestBody Empleado empleado)
	{
		empleadoService.save(empleado);
	}
	
	@PutMapping("/actualizar/{nroEmpleado}")
	@ResponseStatus(HttpStatus.OK)
	public Empleado actualizarEmpleado(@PathVariable long nroEmpleado, @RequestBody Empleado nuevoEmpleado)
	{
		Empleado antiguoEmpleado = empleadoService.findById(nroEmpleado);
		antiguoEmpleado.setNombre(nuevoEmpleado.getNombre());
		antiguoEmpleado.setApellido(nuevoEmpleado.getApellido());
		antiguoEmpleado.setFechaNacimiento(nuevoEmpleado.getFechaNacimiento());
		antiguoEmpleado.setCorreo(nuevoEmpleado.getCorreo());
		antiguoEmpleado.setDni(nuevoEmpleado.getDni());
		antiguoEmpleado.setTelefono(nuevoEmpleado.getTelefono());
		antiguoEmpleado.setDireccion(nuevoEmpleado.getDireccion());
		antiguoEmpleado.setFechaIngreso(nuevoEmpleado.getFechaIngreso());
		antiguoEmpleado.setSalario(nuevoEmpleado.getSalario());
		antiguoEmpleado.setEstado(nuevoEmpleado.getEstado());
		antiguoEmpleado.setRol(nuevoEmpleado.getRol());
		return empleadoService.save(antiguoEmpleado);
	}
	
	@DeleteMapping("/eliminar/{nroEmpleado}")
	public void eliminarEmpleado(@PathVariable long nroEmpleado)
	{
		empleadoService.delete(nroEmpleado);
	}
}
