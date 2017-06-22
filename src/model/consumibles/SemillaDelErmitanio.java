package model.consumibles;

import static model.algoBall.ConstantesDelJuego.SEMILLA_HERMITANEO_NOMBRE;
import static model.algoBall.ConstantesDelJuego.SEMILLA_HERMITANEO_PLUS_VIDA;

import model.personajes.Personaje;
import model.personajes.elementos.Salud;

public class SemillaDelErmitanio extends Consumible {
	
	private Salud plusSalud = new Salud(SEMILLA_HERMITANEO_PLUS_VIDA);

	public SemillaDelErmitanio(){
		this.nombre = SEMILLA_HERMITANEO_NOMBRE;
		this.rutaImagen = "file:src/vista/imagenes/semilla.png";
	};

	@Override
	public void aplicarAPersonaje(Personaje personaje) {
		personaje.regenerarSalud(this.plusSalud);
	}
	
	@Override
	public void aplicarAPersonajeConTemporalAnterior(Personaje personaje){
		this.aplicarAPersonaje(personaje);
	}
}
