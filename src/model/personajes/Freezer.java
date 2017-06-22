package model.personajes;

import static model.algoBall.ConstantesDelJuego.FREEZER_NOMBRE;
import static model.algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_FREEZER;
import static model.algoBall.ConstantesDelJuego.KI_INICIAL;
import static model.algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_FREEZER;
import static model.algoBall.ConstantesDelJuego.PROCENTAJE_DANIO_ATAQ_ESPECIAL_FREEZER;
import static model.algoBall.ConstantesDelJuego.PUNTOS_VIDA_FREEZER;

import model.personajes.elementos.AtaqueEspecial;
import model.personajes.elementos.Ki;
import model.personajes.elementos.Salud;
import model.personajes.freezer.EstadoFreezerNormal;

public class Freezer extends Personaje 
{	
	public Freezer()
	{
		this.nombre = FREEZER_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_FREEZER);
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_FREEZER, KI_ATQ_ESPECIAL_FREEZER);
		this.estadoTransformacionActual = new EstadoFreezerNormal();
		
		this.ataqueEspecial.setPorcentaje(PROCENTAJE_DANIO_ATAQ_ESPECIAL_FREEZER);
		this.rutaImagen = "file:src/vista/imagenes/freezer.png";
	}
	
}