package algoBall;

import java.util.ArrayList;

import notificaciones.NotificacionNoQuedanMovimientos;
import notificaciones.NotificacionPersonajeInexistente;
import exceptions.NoQuedanMovimientosException;
import exceptions.PersonajeInexistenteException;
import funcionamientoPersonaje.Personaje;


public abstract class Movimiento {
	protected abstract void moverEnDireccion(Personaje personaje);
	
	public void prohibirMovimientosMenosA(Personaje personajeQueNo, ArrayList<Personaje> pertenecientes){
		for (Personaje personaje : pertenecientes) {
			if (!(personaje == personajeQueNo)){
				personaje.prohibirMovimientos();
			}
		}
	}
	
	public void mover(Personaje personaje , ArrayList<Personaje> pertenecientes)
	{
		NotificacionPersonajeInexistente notificacionPersonajeInexistenteException = new NotificacionPersonajeInexistente();
		NotificacionNoQuedanMovimientos notificacionNoQuedanMovimientosException = new NotificacionNoQuedanMovimientos();
		
		try {
			this.moverEnDireccion(personaje);
			this.prohibirMovimientosMenosA(personaje,pertenecientes);
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
