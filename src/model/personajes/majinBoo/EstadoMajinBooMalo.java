package model.personajes.majinBoo;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_MAJIN_BOO_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.KI_MAJIN_BOO_SEGUNDA_TRANF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_MAJIN_BOO_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.PODER_MAJIN_BOO_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_MAJIN_BOO_PRIMERA_TRANSF;

import model.personajes.Personaje;
import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoInactivoConChocolate;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoMajinBooMalo extends EstadoTransformacion{
	
	public EstadoMajinBooMalo()
	{
		this.nombre = NOMBRE_MAJIN_BOO_PRIMERA_TRANSF;
		this.velocidad = VELOCIDAD_MAJIN_BOO_PRIMERA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_MAJIN_BOO_PRIMERA_TRANSF;
		this.poderDePelea = new Danio(PODER_MAJIN_BOO_PRIMERA_TRANSF);
		this.siguienteEstado = new EstadoMajinBooOriginal();
		this.kiParaTransformacion = new Ki(KI_MAJIN_BOO_SEGUNDA_TRANF);
		this.rutaImagen = "file:src/vistas/imagenes/booMalo.png";
	}
	
	@Override
	public void realizarAtaqueEspecial(Personaje victima, int porcetajeBonus)
	{	
		EstadoInactivoConChocolate chocolate = new EstadoInactivoConChocolate();
		chocolate.setEstadoAnterior(victima.getEstado());
		victima.setEstado(chocolate);
	}
}
