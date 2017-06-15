package algoBall;

import funcionamientoPersonaje.elementos.EstadoTransformacion;
import funcionamientoPersonaje.personajes.Personaje;
import funcionamientoTablero.Posicion;

public class Jugador 
{
	private String nombre;
	private Agrupacion agrupacion;
	
	public Jugador(String Nombre, String equipo)
	{
		this.nombre = Nombre;
		this.agrupacion = new Agrupacion(equipo);
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public Agrupacion getEquipo()
	{
		return this.agrupacion;
	}
	
	public void agregarPersonaje(Personaje personaje){
		this.agrupacion.agregarPersonaje(personaje);
	}
	
	public boolean existePersonaje(String personaje){
		return (this.agrupacion.existePersonaje(personaje));
	}
	
	public Agrupacion getAgrupacion(){
		return this.agrupacion;
	}
	
	public void reestablecer(){
		agrupacion.reestablecer();
	}
	
	public Posicion obtenerPosicionDe(String nombrePersonaje){
		return this.agrupacion.obtenerPosicionDe(nombrePersonaje);
	}
	
	public int obtenerSaludDe(String nombrePersonaje){
		return this.agrupacion.obtenerSaludDe(nombrePersonaje);
	}
	
	public int getKiDe(String nombrePersonaje){
		return this.agrupacion.getKiDe(nombrePersonaje);
	}

	public Personaje getPersonaje(String nombre) {
		
		return this.agrupacion.getPersonaje(nombre);
	}
	
	public int getCantidadDeAtaquesRestantes(){
		return this.agrupacion.getCantidadDeAtaquesRestantes();
	}

	public int getCantidadDeMovimientosRestantes() {
		return this.agrupacion.getCantidadDeMovimientosRestantes();
		
	}
	
}

