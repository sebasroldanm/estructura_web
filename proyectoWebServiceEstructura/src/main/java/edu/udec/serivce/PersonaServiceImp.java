package edu.udec.serivce;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.udec.entity.Persona;

@Service
public class PersonaServiceImp implements IPeronsaService{

	@Override
	public Persona obtenerPersonaPorNombre(String nombre) {
		System.out.println("Nombre persona:" + nombre);
		Persona persona = new Persona(25, nombre);
		return persona;
	}

	@Override
	public List<Persona> obtenerTotalPersona() {
		List<Persona> listaPersona = new ArrayList<>();
		listaPersona.add(new Persona(30, "Juan"));
		listaPersona.add(new Persona(28, "Laura"));
		return listaPersona;
	}

	@Override
	public Persona guardarPersona(Persona persona) {		
		return persona;
	}

	@Override
	public Persona editarPersona(Persona persona) {		
		return persona;
	}

	@Override
	public void eliminarPersona(int edad) {
			
	}

}
