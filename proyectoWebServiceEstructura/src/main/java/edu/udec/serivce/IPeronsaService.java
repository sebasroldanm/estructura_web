package edu.udec.serivce;

import java.util.List;

import edu.udec.entity.Persona;

public interface IPeronsaService {
	
	public Persona obtenerPersonaPorNombre(String nombre);
	
	public List<Persona> obtenerTotalPersona();
	
	public Persona guardarPersona(Persona persona);
	
	public Persona editarPersona(Persona persona);
	
	public void eliminarPersona(int edad);

}
