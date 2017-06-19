package personajes;

import static algoBall.ConstantesDelJuego.GOHAN_NOMBRE;
import static algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_GOHAN;
import static algoBall.ConstantesDelJuego.KI_INICIAL;
import static algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_GOHAN;
import static algoBall.ConstantesDelJuego.PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOHAN;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOHAN;

import personajes.elementos.AtaqueEspecial;
import personajes.elementos.Ki;
import personajes.elementos.Salud;
import personajes.gohan.EstadoGohanNormal;

public class Gohan extends Personaje 
{	
	public Gohan()
	{
		this.nombre = GOHAN_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_GOHAN);
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_GOHAN, KI_ATQ_ESPECIAL_GOHAN, "src/vista/musica/masenko.mp3");
		this.estadoTransformacionActual = new EstadoGohanNormal();
		this.ataqueEspecial.setPorcentaje(PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOHAN);
		this.rutaImagen = "file:src/vista/imagenes/gohan.png";
	}
	
}