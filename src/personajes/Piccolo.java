package personajes;

import static algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_PICCOLO;
import static algoBall.ConstantesDelJuego.KI_INICIAL;
import static algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_PICCOLO;
import static algoBall.ConstantesDelJuego.PICCOLO_NOMBRE;
import static algoBall.ConstantesDelJuego.PROCENTAJE_DANIO_ATAQ_ESPECIAL_PICCOLO;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_PICCOLO;

import personajes.elementos.AtaqueEspecial;
import personajes.elementos.Ki;
import personajes.elementos.Salud;
import personajes.piccolo.EstadoPiccoloNormal;

public class Piccolo extends Personaje 
{	
	public Piccolo()
	{
		this.nombre = PICCOLO_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_PICCOLO);
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_PICCOLO, KI_ATQ_ESPECIAL_PICCOLO);
		this.ataqueEspecial.setPorcentaje(PROCENTAJE_DANIO_ATAQ_ESPECIAL_PICCOLO);
		this.estadoTransformacionActual = new EstadoPiccoloNormal();
		//this.movimientosRestantes = estadoTransformacionActual.getVelocidad();
		this.rutaImagen = "file:src/vista/imagenes/piccolo.png";
	}
	
}