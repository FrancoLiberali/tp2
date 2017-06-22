package model.personajes;

import static model.algoBall.ConstantesDelJuego.GOKU_NOMBRE;
import static model.algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_GOKU;
import static model.algoBall.ConstantesDelJuego.KI_INICIAL;
import static model.algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_GOKU;
import static model.algoBall.ConstantesDelJuego.PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOKU;
import static model.algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOKU;

import model.personajes.elementos.AtaqueEspecial;
import model.personajes.elementos.Ki;
import model.personajes.elementos.Salud;
import model.personajes.goku.EstadoGokuNormal;

public class Goku extends Personaje 
{	
	
	public Goku()
	{
		this.nombre = GOKU_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_GOKU);
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_GOKU, KI_ATQ_ESPECIAL_GOKU);
		this.ataqueEspecial.setPorcentaje(PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOKU);
		this.estadoTransformacionActual = new EstadoGokuNormal();
		this.rutaImagen = "file:src/vista/imagenes/goku.png";
	}
	
}
