package model.personajes.majinBoo;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_MAJIN_BOO_NORMAL;
import static model.algoBall.ConstantesDelJuego.KI_MAJIN_BOO_PRIMERA_TRANF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static model.algoBall.ConstantesDelJuego.PODER_MAJIN_BOO_NORMAL;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_MAJIN_BOO_NORMAL;

import model.personajes.Personaje;
import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoInactivoConChocolate;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoMajinBooNormal extends EstadoTransformacion {

	
	public EstadoMajinBooNormal()
	{
		this.nombre = NOMBRE_TRANF_NORMAL;
		this.velocidad = VELOCIDAD_MAJIN_BOO_NORMAL;
		this.distanciaDeAtaque = DISTANCIA_MAJIN_BOO_NORMAL;
		this.poderDePelea = new Danio(PODER_MAJIN_BOO_NORMAL);
		this.siguienteEstado = new EstadoMajinBooMalo();
		this.kiParaTransformacion = new Ki(KI_MAJIN_BOO_PRIMERA_TRANF);
		this.rutaImagen = "file:src/vista/imagenes/booNormal.png";
	}
	
	
	@Override
	public void realizarAtaqueEspecial(Personaje victima, int porcetajeBonus)
	{	
		EstadoInactivoConChocolate chocolate = new EstadoInactivoConChocolate();
		chocolate.setEstadoAnterior(victima.getEstado());
		victima.setEstado(chocolate);
	}
}
	
	
	
	
