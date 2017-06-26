package model.consumibles;

import static model.algoBall.ConstantesDelJuego.NUBE_VOLADORA_NOMBRE;

import model.personajes.Personaje;
import model.personajes.elementos.EstadoActividad;

public class NubeVoladora extends Consumible{
	
	public NubeVoladora(){
		this.nombre = NUBE_VOLADORA_NOMBRE;
		this.rutaImagen = "file:src/vistas/imagenes/nube.png";
	}

	@Override
	public void aplicarAPersonaje(Personaje personaje) {
		EstadoActividad estado = new EstadoBuffVelocidad(personaje.getEstado());
		personaje.setEstado(estado);
	}
	
	@Override
	public void aplicarAPersonajeConTemporalAnterior(Personaje personaje){
		int velocidadAnterior = personaje.getVelocidad();
		EstadoActividad estado = new EstadoBuffVelocidad(personaje.getEstado());
		personaje.setEstado(estado.getEstadoSiguiente());
		personaje.actualizarMovimientosRestantes(velocidadAnterior);
	}
	
}
