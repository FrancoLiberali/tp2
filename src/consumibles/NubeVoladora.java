package consumibles;

import static algoBall.ConstantesDelJuego.NUBE_VOLADORA_NOMBRE;

import personajes.Personaje;
import personajes.elementos.EstadoActividad;

public class NubeVoladora extends Consumible{
	
	public NubeVoladora(){
		this.nombre = NUBE_VOLADORA_NOMBRE;
		this.rutaImagen = "file:src/vista/imagenes/nube.png";
	}

	@Override
	public void aplicarAPersonaje(Personaje personaje) {
		EstadoActividad estado = new EstadoBuffVelocidad(personaje.getEstado());
		personaje.setEstado(estado);
	}
	
}
