package algoBall;

import java.util.ArrayList;

import exceptions.PersonajeInexistenteException;
import funcionamientoPersonaje.EstadoTransformacion;
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
	
	public void moverIzquierda(String nombrePersonaje)
	{
		moverIzquierda movimiento = new moverIzquierda();
		movimiento.mover(this,nombrePersonaje);
		
	}
	
	public void moverAbajo(String nombrePersonaje)
	{
		moverAbajo movimiento = new moverAbajo();
		movimiento.mover(this,nombrePersonaje);
	}
	public void moverDerecha(String nombrePersonaje)
	{
		moverDerecha movimiento = new moverDerecha();
		movimiento.mover(this,nombrePersonaje);
	}
	public void moverArriba(String nombrePersonaje)
	{
		moverArriba movimiento = new moverArriba();
		movimiento.mover(this,nombrePersonaje);
	}
	
	public void reestablecer(){
		for (Personaje personaje : pertenecientes) {
			personaje.reestablecer();
		}
	}
	
	public void realizarAtaqueBasico(String nombrePersonaje, Posicion posicionVictima){
		Personaje personaje = this.getPersonaje(nombrePersonaje);
		personaje.realizarAtaqueBasico(posicionVictima);
	}
	
	public void realizarAtaqueEspecial(String nombrePersonaje, Posicion posicionVictima){
		Personaje personaje = this.getPersonaje(nombrePersonaje);
		personaje.realizarAtaqueEspecial(posicionVictima);
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
		return personaje.getKi();
	}
	
	public void transformar(String nombrePersonaje){
		Personaje personaje = this.getPersonaje(nombrePersonaje);
		personaje.transformar();
	}
	
	public EstadoTransformacion getEstadoTransformacion(String nombrePersonaje){
		Personaje personaje = this.getPersonaje(nombrePersonaje);
		return personaje.getEstadoTransformacion();
	}
}
