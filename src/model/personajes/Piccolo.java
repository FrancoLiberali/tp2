package model.personajes;

import static model.algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_PICCOLO;
import static model.algoBall.ConstantesDelJuego.KI_INICIAL;
import static model.algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_PICCOLO;
import static model.algoBall.ConstantesDelJuego.PICCOLO_NOMBRE;
import static model.algoBall.ConstantesDelJuego.PROCENTAJE_DANIO_ATAQ_ESPECIAL_PICCOLO;
import static model.algoBall.ConstantesDelJuego.PUNTOS_VIDA_PICCOLO;

import model.personajes.elementos.AtaqueEspecial;
import model.personajes.elementos.Ki;
import model.personajes.elementos.Salud;
import model.personajes.piccolo.EstadoPiccoloNormal;

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
		this.rutaImagen = "file:src/vistas/imagenes/piccolo.png";
	}
	
}