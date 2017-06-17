package algoBall;

import java.util.ArrayList;

import exceptions.PersonajeInexistenteException;
import personajes.Personaje;
import tablero.Posicion;

public class Equipo 
{	
	private String nombre;
	private ArrayList<Personaje> pertenecientes = new ArrayList<Personaje>();
	private int cantidadAtaquesRestantes = 1;
	private int cantidadMovimientosRestantes = 1;
	
	public Equipo(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void agregarPersonaje(Personaje psje)
	{
		pertenecientes.add(psje);
		psje.setEquipo(this);
	}
	 
	public void restarAtaqueRestates()
	{
		this.cantidadAtaquesRestantes --;
	}
	
	public void restarMovimientosRestantes(){
		this.cantidadMovimientosRestantes--;
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
	
	public void reestablecer(){
		this.cantidadAtaquesRestantes = 1;
		this.cantidadMovimientosRestantes = 1;
		for (Personaje personaje : pertenecientes) {
			personaje.reestablecer();
		}
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
		if (pertenecientes.isEmpty()){
			throw new JuegoTerminado();
		}
	}
	
	public Posicion obtenerPosicionDe(String nombrePersonaje){
		Personaje personaje = this.getPersonaje(nombrePersonaje);
		return personaje.getPosicion();
	}
	
	public int obtenerSaludDe(String nombrePersonaje){
		Personaje personaje = this.getPersonaje(nombrePersonaje);
		return personaje.getSalud();
	}
	
	public int getKiDe(String nombrePersonaje){
		Personaje personaje = this.getPersonaje(nombrePersonaje);
		return personaje.getKiCantidad();
	}

	public int getCantidadDeAtaquesRestantes() {
		return this.cantidadAtaquesRestantes;
	}

	public int getCantidadDeMovimientosRestantes() {
		return this.cantidadMovimientosRestantes;
	}
	
	
}
