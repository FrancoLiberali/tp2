package personajes;

import static algoBall.ConstantesDelJuego.FREEZER_NOMBRE;
import static algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_FREEZER;
import static algoBall.ConstantesDelJuego.KI_INICIAL;
import static algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_FREEZER;
import static algoBall.ConstantesDelJuego.PROCENTAJE_DANIO_ATAQ_ESPECIAL_FREEZER;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_FREEZER;

import personajes.elementos.AtaqueEspecial;
import personajes.elementos.Ki;
import personajes.elementos.Salud;
import personajes.freezer.EstadoFreezerNormal;

public class Freezer extends Personaje 
{	
	
	public Freezer()
	{
		this.nombre = FREEZER_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_FREEZER);
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_FREEZER, KI_ATQ_ESPECIAL_FREEZER);
<<<<<<< HEAD
		this.estadoTransformacionActual = new EstadoFreezerNormal();
		this.movimientosRestantes = estadoTransformacionActual.getVelocidad();
=======
		this.estadoTransformacionActual = setEstadoNormal();
>>>>>>> 725fe55233c63811d8188aa2745687d5fd216d19
		this.ataqueEspecial.setPorcentaje(PROCENTAJE_DANIO_ATAQ_ESPECIAL_FREEZER);
		this.rutaImagen = "file:src/vista/imagenes/freezer.png";
	}
	
}