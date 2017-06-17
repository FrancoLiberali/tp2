package personajes.majinBoo;

import static algoBall.ConstantesDelJuego.DISTANCIA_MAJIN_BOO_NORMAL;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_MAJIN_BOO_NORMAL;
import static algoBall.ConstantesDelJuego.VELOCIDAD_MAJIN_BOO_NORMAL;
import personajes.Personaje;
import personajes.elementos.EstadoInactivoConChocolate;
import personajes.elementos.EstadoTransformacion;

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
	public void realizarAtaqueEspecial(Personaje victima, int porcetajeBonus)
	{	
		victima.setEstado(new EstadoInactivoConChocolate());
	}
}
	
	
	
	
