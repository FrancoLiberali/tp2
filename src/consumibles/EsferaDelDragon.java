package consumibles;

import static algoBall.ConstantesDelJuego.ESFERA_DEL_DRAGON_NOMBRE;

import personajes.Personaje;
import personajes.elementos.EstadoActividad;

public class EsferaDelDragon extends Consumible 
{
	
	public EsferaDelDragon(){
		this.nombre = ESFERA_DEL_DRAGON_NOMBRE;
		this.rutaImagen = "file:src/vista/imagenes/esfera.png";
	}

	@Override
	public void aplicarAPersonaje(Personaje personaje) 
	{
		EstadoActividad estado = new EstadoBuffDanio(personaje.getEstado());
		personaje.setEstado(estado);
	}
	
	public void aplicarAPersonajeConTemporalAnterior(Personaje personaje){
		EstadoActividad estado = new EstadoBuffDanio(personaje.getEstado());
		personaje.setEstado(estado.getEstadoSiguiente());
	}

}
