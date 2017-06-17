package personajes.majinBoo;

import static algoBall.ConstantesDelJuego.DISTANCIA_MAJIN_BOO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_MAJIN_BOO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_MAJIN_BOO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_MAJIN_BOO_PRIMERA_TRANSF;

import personajes.Personaje;
import personajes.elementos.EstadoInactivoConChocolate;
import personajes.elementos.EstadoTransformacion;

public class EstadoMajinBooMalo extends EstadoTransformacion{
	
	public EstadoMajinBooMalo()
	{
		this.nombre = NOMBRE_MAJIN_BOO_PRIMERA_TRANSF;
		this.velocidad = VELOCIDAD_MAJIN_BOO_PRIMERA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_MAJIN_BOO_PRIMERA_TRANSF;
		this.poderDePelea = PODER_MAJIN_BOO_PRIMERA_TRANSF;
		this.siguienteEstado = new EstadoMajinBooOriginal();	
	}
	
	@Override
	public void realizarAtaqueEspecial(Personaje victima, int porcetajeBonus)
	{	
		victima.setEstado(new EstadoInactivoConChocolate());
	}
}
