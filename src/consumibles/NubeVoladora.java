package consumibles;

import personajes.Personaje;
import personajes.elementos.EstadoActividad;
import static algoBall.ConstantesDelJuego.NUBE_VOLADORA_NOMBRE;

public class NubeVoladora extends Consumible{
	
	public NubeVoladora(){
		this.nombre = NUBE_VOLADORA_NOMBRE;
	}

	@Override
	public void aplicarAPersonaje(Personaje personaje) {
		EstadoActividad estado = new EstadoBuffVelocidad(personaje.getEstado());
		personaje.setEstado(estado);
	}
	
}
