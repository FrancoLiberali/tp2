package algoBall;

import java.util.ArrayList;

import exceptions.PersonajeInexistenteException;
import funcionamientoPersonaje.Personaje;
import funcionamientoTablero.Posicion;

public class Agrupacion 
{	
	private String nombre;
	private ArrayList<Personaje> pertenecientes = new ArrayList<Personaje>();
	
	public Agrupacion(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void agregarPersonaje(Personaje psje)
	{
		pertenecientes.add(psje);
		psje.setAgrupacion(this);
	}
	
	public boolean perteneceMismaAgrupacion(Personaje psje)
	{
		return this.pertenecientes.contains(psje);
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public Personaje getPersonaje(String personajeBuscado)
	{
		Personaje personajeEncontrado = null;
		if(!this.existePersonaje(personajeBuscado))
		{
			throw new PersonajeInexistenteException();
		}
		for (Personaje personaje : pertenecientes) {
			if (personaje.getNombre() == personajeBuscado){
				personajeEncontrado = personaje;
			}
		}
		return personajeEncontrado;
	}
	
	public boolean existePersonaje(String personajeBuscado) 
	{
		for (Personaje personaje : pertenecientes) {
			if (personaje.getNombre() == personajeBuscado){
				return true;
			}
		}
		return false;
	}
	
	public void moverIzquierda(String nombrePersonaje){
		Personaje personaje = this.getPersonaje(nombrePersonaje);
		personaje.moverIzquierda();
		this.prohibirMovimientosMenosA(personaje);
	}
	public void moverAbajo(String nombrePersonaje){
		Personaje personaje = this.getPersonaje(nombrePersonaje);
		personaje.moverAbajo();
		this.prohibirMovimientosMenosA(personaje);
	}
	public void moverDerecha(String nombrePersonaje){
		Personaje personaje = this.getPersonaje(nombrePersonaje);
		personaje.moverDerecha();
		this.prohibirMovimientosMenosA(personaje);
	}
	public void moverArriba(String nombrePersonaje){
		Personaje personaje = this.getPersonaje(nombrePersonaje);
		personaje.moverArriba();
		this.prohibirMovimientosMenosA(personaje);
	}
	
	public void reestablecer(){
		for (Personaje personaje : pertenecientes) {
			personaje.reestablecer();
		}
	}
	
	public void realizarAtaqueBasico(String nombrePersonaje, Posicion posicionVictima){
		Personaje personaje = this.getPersonaje(nombrePersonaje);
		personaje.atacar(posicionVictima);
	}
	
	public void prohibirMovimientosMenosA(Personaje personajeQueNo){
		for (Personaje personaje : pertenecientes) {
			if (!(personaje == personajeQueNo)){
				personaje.prohibirMovimientos();
			}
		}
	}
	
	public void eliminar(Personaje personajeAEliminar){
		pertenecientes.remove(personajeAEliminar);
	}
}
