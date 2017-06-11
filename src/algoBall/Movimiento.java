package algoBall;


import  algoBall.Agrupacion;
import notificaciones.NotificacionNoQuedanMovimientos;
import notificaciones.NotificacionPersonajeInexistente;
import exceptions.NoQuedanMovimientosException;
import exceptions.PersonajeInexistenteException;
import funcionamientoPersonaje.Personaje;


public abstract class Movimiento {
	protected abstract void moverEnDireccion(Personaje personaje);
	
	
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
