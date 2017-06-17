package personajes.majinBoo;

import static algoBall.ConstantesDelJuego.DISTANCIA_MAJIN_BOO_NORMAL;
import static algoBall.ConstantesDelJuego.KI_MAJIN_BOO_PRIMERA_TRANF;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_MAJIN_BOO_NORMAL;
import static algoBall.ConstantesDelJuego.VELOCIDAD_MAJIN_BOO_NORMAL;
import personajes.Personaje;
import personajes.elementos.EstadoInactivoConChocolate;
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
		this.kiParaTransformacion = new Ki(KI_MAJIN_BOO_PRIMERA_TRANF);
	}
	
	
	@Override
	public void realizarAtaqueEspecial(Personaje victima, int porcetajeBonus)
	{	
		victima.setEstado(new EstadoInactivoConChocolate());
	}
}
	
	
	
	
