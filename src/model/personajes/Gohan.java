package model.personajes;

import static model.algoBall.ConstantesDelJuego.GOHAN_NOMBRE;
import static model.algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_GOHAN;
import static model.algoBall.ConstantesDelJuego.KI_INICIAL;
import static model.algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_GOHAN;
import static model.algoBall.ConstantesDelJuego.PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOHAN;
import static model.algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOHAN;

import model.personajes.elementos.AtaqueEspecial;
import model.personajes.elementos.Ki;
import model.personajes.elementos.Salud;
import model.personajes.gohan.EstadoGohanNormal;

public class Gohan extends Personaje 
{	
	public Gohan()
	{
		this.nombre = GOHAN_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_GOHAN);
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_GOHAN, KI_ATQ_ESPECIAL_GOHAN);
		this.estadoTransformacionActual = new EstadoGohanNormal();
		this.ataqueEspecial.setPorcentaje(PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOHAN);
		this.rutaImagen = "file:src/vistas/imagenes/gohan.png";
	}
	
}