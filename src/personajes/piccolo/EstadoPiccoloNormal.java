package personajes.piccolo;

import static algoBall.ConstantesDelJuego.DISTANCIA_PICCOLO_NORMAL;
import static algoBall.ConstantesDelJuego.KI_PICCOLO_PRIMERA_TRANF;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_PICCOLO_NORMAL;
import static algoBall.ConstantesDelJuego.VELOCIDAD_PICCOLO_NORMAL;

import exceptions.NoCumpleCondicionesDeTransformacionException;
import exceptions.PersonajeInexistenteException;
import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;
import personajes.elementos.Ki;

public class EstadoPiccoloNormal extends EstadoTransformacion {
	
	public EstadoPiccoloNormal()
	{
		this.nombre = NOMBRE_TRANF_NORMAL;
		this.velocidad = VELOCIDAD_PICCOLO_NORMAL;
		this.distanciaDeAtaque = DISTANCIA_PICCOLO_NORMAL;
		this.poderDePelea = PODER_PICCOLO_NORMAL;
		this.siguienteEstado = new EstadoPiccoloFortalecido();
		this.kiParaTransformacion = new Ki(KI_PICCOLO_PRIMERA_TRANF);
	}
}
