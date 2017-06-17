package personajes.majinBoo;

import static algoBall.ConstantesDelJuego.DISTANCIA_MAJIN_BOO_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_MAJIN_BOO_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_MAJIN_BOO_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_MAJIN_BOO_SEGUNDA_TRANSF;

import exceptions.YaNoPuedeEvolucionarException;
import personajes.Personaje;
import personajes.elementos.EstadoInactivoConChocolate;
import personajes.elementos.EstadoTransformacion;

public class EstadoMajinBooOriginal extends EstadoTransformacion {
	
	
	public EstadoMajinBooOriginal()
	{
		this.nombre = NOMBRE_MAJIN_BOO_SEGUNDA_TRANSF;
		this.velocidad = VELOCIDAD_MAJIN_BOO_SEGUNDA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_MAJIN_BOO_SEGUNDA_TRANSF;
		this.poderDePelea = PODER_MAJIN_BOO_SEGUNDA_TRANSF;
		this.siguienteEstado = null;	
	}
	
	@Override
	public void transformar(Personaje personaje) {
		throw new YaNoPuedeEvolucionarException();
	}
	
	
	@Override
	public void realizarAtaqueEspecial(Personaje victima, int porcetajeBonus)
	{	
		victima.setEstado(new EstadoInactivoConChocolate());
	}
}
