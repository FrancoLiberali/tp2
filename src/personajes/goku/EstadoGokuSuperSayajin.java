package personajes.goku;

import static algoBall.ConstantesDelJuego.DISTANCIA_GOKU_SEGUNDA_TRANF;
import static algoBall.ConstantesDelJuego.NOMBRE_GOKU_SEGUNDA_TRANF;
import static algoBall.ConstantesDelJuego.PODER_GOKU_SEGUNDA_TRANF;
import static algoBall.ConstantesDelJuego.PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU;
import static algoBall.ConstantesDelJuego.VELOCIDAD_GOKU_SEGUNDA_TRANF;

import exceptions.YaNoPuedeEvolucionarException;
import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;

public class EstadoGokuSuperSayajin extends EstadoTransformacion {

	public EstadoGokuSuperSayajin()
	{
		this.nombre = NOMBRE_GOKU_SEGUNDA_TRANF;
		this.velocidad = VELOCIDAD_GOKU_SEGUNDA_TRANF;
		this.distanciaDeAtaque = DISTANCIA_GOKU_SEGUNDA_TRANF;
		this.poderDePelea = PODER_GOKU_SEGUNDA_TRANF;
		this.siguienteEstado = null;
	}
	
	@Override
	public void transformar(Personaje personaje) {
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
