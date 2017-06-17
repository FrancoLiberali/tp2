package personajes.piccolo;

import static algoBall.ConstantesDelJuego.DISTANCIA_PICCOLO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.GOHAN_NOMBRE;
import static algoBall.ConstantesDelJuego.NOMBRE_PICCOLO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_PICCOLO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PORCENTAJE_VIDA_GOHAN_PROTECTOR;
import static algoBall.ConstantesDelJuego.VELOCIDAD_PICCOLO_PRIMERA_TRANSF;

import exceptions.NoCumpleCondicionesDeTransformacionException;
import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;

public class EstadoPiccoloFortalecido extends EstadoTransformacion {
	
	private int porcentajeSaludGohanParaTransf = PORCENTAJE_VIDA_GOHAN_PROTECTOR;
	
	public EstadoPiccoloFortalecido()
	{
		this.nombre = NOMBRE_PICCOLO_PRIMERA_TRANSF;
		this.velocidad = VELOCIDAD_PICCOLO_PRIMERA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_PICCOLO_PRIMERA_TRANSF;
		this.poderDePelea = PODER_PICCOLO_PRIMERA_TRANSF;
		this.siguienteEstado = new EstadoPiccoloProtector();
	}
	
	@Override
	public void transformar(Personaje personaje){
		if (!this.cumpleCondicionesProtector(personaje)){
			throw new NoCumpleCondicionesDeTransformacionException();
		}
		super.transformar(personaje);
	}
	
	private boolean cumpleCondicionesProtector(Personaje piccolo){
		Personaje gohan = piccolo.getCompaniero(GOHAN_NOMBRE);
		return gohan.getPorcentajeSalud() < this.porcentajeSaludGohanParaTransf;
		
	}
}
