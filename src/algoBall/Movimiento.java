package algoBall;


import  algoBall.Agrupacion;
import notificaciones.NotificacionNoQuedanMovimientos;
import notificaciones.NotificacionPersonajeInexistente;
import exceptions.NoQuedanMovimientosException;
import exceptions.PersonajeInexistenteException;
import funcionamientoPersonaje.Personaje;
import funcionamientoTablero.Posicion;

public abstract class Movimiento {
	
	protected abstract Posicion darPosicionNueva(Posicion posicion);
	
	protected void moverEnDireccion(Personaje personaje)
	{
		Posicion posicion = personaje.getPosicion();
		Posicion posicion_nueva = darPosicionNueva(posicion);
		personaje.mover(posicion_nueva);
	}
	
	public void mover(Agrupacion equipo, String nombreDelPersonaje )
	{
		NotificacionPersonajeInexistente notificacionPersonajeInexistenteException = new NotificacionPersonajeInexistente();
		NotificacionNoQuedanMovimientos notificacionNoQuedanMovimientosException = new NotificacionNoQuedanMovimientos();
		
		try {
			Personaje personaje = equipo.getPersonaje(nombreDelPersonaje);
			this.moverEnDireccion(personaje);
			equipo.prohibirMovimientosMenosA(personaje);
		}
		catch (PersonajeInexistenteException error){
			/*mensaje al usuario*/
			notificacionPersonajeInexistenteException.notificar(); 
		}
		catch (NoQuedanMovimientosException error){
			/*mensaje al usuario*/
			notificacionNoQuedanMovimientosException.notificar(); 
		}
	}

}
