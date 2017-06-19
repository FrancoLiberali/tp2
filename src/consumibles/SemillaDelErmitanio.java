package consumibles;

import static algoBall.ConstantesDelJuego.SEMILLA_HERMITANEO_NOMBRE;
import static algoBall.ConstantesDelJuego.SEMILLA_HERMITANEO_PLUS_VIDA;

import personajes.Personaje;

public class SemillaDelErmitanio extends Consumible {
	
	private int plusSalud = SEMILLA_HERMITANEO_PLUS_VIDA;

	public SemillaDelErmitanio(){
		this.nombre = SEMILLA_HERMITANEO_NOMBRE;
		this.rutaImagen = "file:src/vista/imagenes/semilla.png";
	};

	@Override
	public void aplicarAPersonaje(Personaje personaje) {
		personaje.regenerarSalud(this.plusSalud);
	}
}
