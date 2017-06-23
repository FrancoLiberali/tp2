package model.personajes.goku;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_GOKU_SEGUNDA_TRANF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_GOKU_SEGUNDA_TRANF;
import static model.algoBall.ConstantesDelJuego.PODER_GOKU_SEGUNDA_TRANF;
import static model.algoBall.ConstantesDelJuego.PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_GOKU_SEGUNDA_TRANF;

import model.exceptions.YaNoPuedeEvolucionarException;
import model.personajes.Personaje;
import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoGokuSuperSayajin extends EstadoTransformacion {

	public EstadoGokuSuperSayajin()
	{
		this.nombre = NOMBRE_GOKU_SEGUNDA_TRANF;
		this.velocidad = VELOCIDAD_GOKU_SEGUNDA_TRANF;
		this.distanciaDeAtaque = DISTANCIA_GOKU_SEGUNDA_TRANF;
		this.poderDePelea = new Danio(PODER_GOKU_SEGUNDA_TRANF);
		this.siguienteEstado = null;
		this.rutaImagen = "file:src/vistas/imagenes/gokuSuperSaiyan.png";
	}
	
	@Override
	public void transformar(Personaje personaje, Ki kiPersonaje) {
		throw new YaNoPuedeEvolucionarException();
	}
	
	@Override
	public void actualizarEstado(Personaje goku)
	{
		if(goku.getPorcentajeSalud() < PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU){
			goku.setEstado(new EstadoGokuBuffDanio(goku.getEstado()));
		}
	}
}
