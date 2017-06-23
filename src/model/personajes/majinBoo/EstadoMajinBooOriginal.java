package model.personajes.majinBoo;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_MAJIN_BOO_SEGUNDA_TRANSF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_MAJIN_BOO_SEGUNDA_TRANSF;
import static model.algoBall.ConstantesDelJuego.PODER_MAJIN_BOO_SEGUNDA_TRANSF;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_MAJIN_BOO_SEGUNDA_TRANSF;

import model.exceptions.YaNoPuedeEvolucionarException;
import model.personajes.Personaje;
import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoInactivoConChocolate;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoMajinBooOriginal extends EstadoTransformacion {
	
	
	public EstadoMajinBooOriginal()
	{
		this.nombre = NOMBRE_MAJIN_BOO_SEGUNDA_TRANSF;
		this.velocidad = VELOCIDAD_MAJIN_BOO_SEGUNDA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_MAJIN_BOO_SEGUNDA_TRANSF;
		this.poderDePelea = new Danio(PODER_MAJIN_BOO_SEGUNDA_TRANSF);
		this.siguienteEstado = null;	
		this.rutaImagen = "file:src/vistas/imagenes/booOriginal.png";
	}
	
	@Override
	public void transformar(Personaje personaje, Ki kiPersonaje) {
		throw new YaNoPuedeEvolucionarException();
	}
	
	
	@Override
	public void realizarAtaqueEspecial(Personaje victima, int porcetajeBonus)
	{	
		EstadoInactivoConChocolate chocolate = new EstadoInactivoConChocolate();
		chocolate.setEstadoAnterior(victima.getEstado());
		victima.setEstado(chocolate);
	}
}
