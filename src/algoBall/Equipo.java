package algoBall;

import java.util.ArrayList;
import java.util.Iterator;

import exceptions.PersonajeInexistenteException;
import funcionamientoPersonaje.elementos.Movimiento;
import personajes.Personaje;
import tablero.Posicion;

public class Equipo implements Iterable<Personaje> 
{	
	private String nombre;
	private ArrayList<Personaje> pertenecientes = new ArrayList<Personaje>();
	private int cantidadAtaquesRestantes = 1;
	private Movimiento movimiento = new Movimiento();
	
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
		for (Personaje personaje : pertenecientes) {
			personaje.reestablecer();
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

	public int getCantidadDeAtaquesRestantes() {
		return this.cantidadAtaquesRestantes;
	}
	
	public void moverIzquierda(Personaje personaje)
	{	
		movimiento.moverIzquierda(personaje);
	}
	
	public void moverDerecha(Personaje personaje)
	{
		movimiento.moverDerecha(personaje);
	}
	
	public void moverArriba(Personaje personaje)
	{
		movimiento.moverArriba(personaje);
	}
	
	public void moverAbajo(Personaje personaje)
	{
		movimiento.moverAbajo(personaje);
	}
	
	public void moverArribaIzquierda(Personaje personaje)
	{	
		movimiento.moverArribaIzquierda(personaje);
	}
	
	public void moverArribaDerecha(Personaje personaje)
	{
		movimiento.moverArribaDerecha(personaje);
	}
	
	public void moverAbajoDerecha(Personaje personaje)
	{
		movimiento.moverAbajoDerecha(personaje);
	}
	
	public void moverAbajoIzquierda(Personaje personaje)
	{
		movimiento.moverAbajoIzquierda(personaje);
	}
	
	public void actualizarMovimientosRestantes(Personaje personaje,int velocidadAnterior, int velocidadActual){
		movimiento.actualizarMovimientosRestantes(personaje, velocidadAnterior, velocidadActual);
		
	}

	@Override
	public Iterator<Personaje> iterator() {
		return pertenecientes.iterator();
	}
	
	
	
}
