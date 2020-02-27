package edu.udec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

import edu.udec.entity.Persona;
import edu.udec.serivce.IPeronsaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	IPeronsaService personaService;
	
	@GetMapping("/listaPersonasPorNombre/{nombre}")
	public ResponseEntity<Persona> listarPersonaNombre(@PathVariable String nombre) {
		Persona persona = personaService.obtenerPersonaPorNombre(nombre);		
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);		
		 
	}
	
	@GetMapping("/listaPersonas")
	public ResponseEntity<List<Persona>> listarPersona() {
		List<Persona> listaPersona = personaService.obtenerTotalPersona();
		return new ResponseEntity<List<Persona>>(listaPersona, HttpStatus.OK);
	}
	
	@PostMapping("/guardarPersona")
	public ResponseEntity<Persona> guardarPersona(@RequestBody Persona persona) {
		Persona persona2 = personaService.guardarPersona(persona);
		return new ResponseEntity<Persona>(persona2, HttpStatus.CREATED);
	}
	
	@PutMapping("/editarPersona")
	public ResponseEntity<Persona> editarPersona(@RequestBody Persona persona) {
		Persona persona2 = personaService.editarPersona(persona);
		HttpHeaders header = new HttpHeaders();
		header.add("Custome-Header", "foo");
		return new ResponseEntity<Persona>(persona2, header, HttpStatus.CREATED);		
	}
	
	@DeleteMapping("/borrarPersona/{edad}")
	public ResponseEntity borrarPersona(@PathVariable int edad) {		
		personaService.eliminarPersona(edad);
		return new ResponseEntity(HttpStatus.OK);
	}
	

}
