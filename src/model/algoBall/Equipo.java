package model.algoBall;

import java.util.ArrayList;
import java.util.Iterator;

import model.exceptions.PersonajeInexistenteException;
import model.personajes.Personaje;
import model.personajes.elementos.Direccion;
import model.personajes.elementos.Movimiento;
import model.personajes.elementos.PanelCaracteristicas;

public class Equipo implements Iterable<Personaje> 
{	
	private String nombre;
	private ArrayList<Personaje> pertenecientes = new ArrayList<Personaje>();
	private int cantidadAtaquesRestantes = 1;
	private Movimiento movimiento = new Movimiento();
	PanelCaracteristicas caracteristicasDelEquipo = new PanelCaracteristicas();
	
	public Equipo(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void agregarPersonaje(Personaje psje)
	{
		pertenecientes.add(psje);
		psje.setEquipo(this);
		caracteristicasDelEquipo.setCaracteristicas(psje);
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
		movimiento = new Movimiento();
		for (Personaje personaje : pertenecientes) {
			personaje.reestablecer();
			caracteristicasDelEquipo.setCaracteristicas(personaje);

		}
	}
	
	public void eliminar(Personaje personajeAEliminar){
		pertenecientes.remove(personajeAEliminar);
		if (pertenecientes.isEmpty()){
			throw new JuegoTerminado();
		}
	}

	public int getCantidadDeAtaquesRestantes() {
		return this.cantidadAtaquesRestantes;
	}
	
	public void mover(Personaje personaje, Direccion direccion){
		movimiento.mover(personaje, direccion);
	}
	
	public void transformar (Personaje personaje){
		personaje.transformar();
		caracteristicasDelEquipo.setCaracteristicas(personaje);
	}
	
	public void actualizarMovimientosRestantes(Personaje personaje,int velocidadAnterior, int velocidadActual){
		movimiento.actualizarMovimientosRestantes(personaje, velocidadAnterior, velocidadActual);
		
	}

	@Override
	public Iterator<Personaje> iterator() {
		return pertenecientes.iterator();
	}
	
	public ArrayList<Personaje> companierosDe(Personaje personajeBuscado) {
		ArrayList<Personaje> companieros = new ArrayList<Personaje>();
		for (Personaje personaje : this.pertenecientes) {
			if (personajeBuscado != personaje){
				companieros.add(personaje);
			}
		}
		return companieros;
	}
	
	public int mayorPorcentajeSaludDeCompanierosDe(Personaje psje)
	{
		int mayorPorcentaje = 0;
		ArrayList<Personaje> companieros = this.companierosDe(psje);
		
		for (Personaje personaje : companieros){
			int porcentajePsje = personaje.getPorcentajeSalud();
			if (porcentajePsje > mayorPorcentaje){
				mayorPorcentaje = porcentajePsje;
			}
		}
		return mayorPorcentaje;
	}

	public int getAtaquesRestantes() {
		
		return this.cantidadAtaquesRestantes;
	}
	
	public PanelCaracteristicas getPanelCaracteristicas(){
		return this.caracteristicasDelEquipo;
	}
	
}
