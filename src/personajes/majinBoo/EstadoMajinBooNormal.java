package personajes.majinBoo;

import static algoBall.ConstantesDelJuego.DISTANCIA_MAJIN_BOO_NORMAL;
import static algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_MAJIN_BOO;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_MAJIN_BOO_NORMAL;
import static algoBall.ConstantesDelJuego.VELOCIDAD_MAJIN_BOO_NORMAL;
import static algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_MAJIN_BOO;

import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;
import personajes.elementos.Ki;

public class EstadoMajinBooNormal extends EstadoTransformacion {

	
	public EstadoMajinBooNormal()
	{
		this.nombre = NOMBRE_TRANF_NORMAL;
		this.velocidad = VELOCIDAD_MAJIN_BOO_NORMAL;
		this.distanciaDeAtaque = DISTANCIA_MAJIN_BOO_NORMAL;
		this.poderDePelea = PODER_MAJIN_BOO_NORMAL;
		this.siguienteEstado = new EstadoMajinBooMalo();	
	}
	
	
	@Override
	public void transformar(Ki kiPersonaje) {
		// TODO Auto-generated method stub
		
	}
}
	
	
	
	
