package model.algoBall;

import model.exceptions.EquipoInexistenteException;
import model.personajes.Personaje;

public class Jugador 
{
	private String nombre;
	private Equipo equipo;
	
	public Jugador(String Nombre, String equipo)
	{
		this.nombre = Nombre;
		this.equipo = new Equipo(equipo);
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public Equipo getEquipo()
	{
		return this.equipo;
	}
	
	public void agregarPersonaje(Personaje personaje){
		this.equipo.agregarPersonaje(personaje);
	}
	
	public boolean existePersonaje(String personaje){
		return (this.equipo.existePersonaje(personaje));
	}
	
	public void reestablecer(){
		equipo.reestablecer();
	}

	public Personaje getPersonaje(String nombre) {
		
		return this.equipo.getPersonaje(nombre);
	}
	
	public int getCantidadDeAtaquesRestantes(){
		return this.equipo.getCantidadDeAtaquesRestantes();
	}
	
	public Equipo getEquipo(String nombre) {
		if (equipo.getNombre() != nombre){
			throw new EquipoInexistenteException();
		}
		return equipo;
	}
}

