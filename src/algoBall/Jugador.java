package algoBall;

import exceptions.EquipoInexistenteException;
import personajes.Personaje;
import tablero.Posicion;

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
	
	public Posicion obtenerPosicionDe(String nombrePersonaje){
		return this.equipo.obtenerPosicionDe(nombrePersonaje);
	}
	
	public int obtenerSaludDe(String nombrePersonaje){
		return this.equipo.obtenerSaludDe(nombrePersonaje);
	}
	
	public int getKiDe(String nombrePersonaje){
		return this.equipo.getKiDe(nombrePersonaje);
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

