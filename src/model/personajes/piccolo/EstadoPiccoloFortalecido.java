package model.personajes.piccolo;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_PICCOLO_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.GOHAN_NOMBRE;
import static model.algoBall.ConstantesDelJuego.KI_PICCOLO_SEGUNDA_TRANF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_PICCOLO_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.PODER_PICCOLO_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.PORCENTAJE_VIDA_GOHAN_PROTECTOR;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_PICCOLO_PRIMERA_TRANSF;

import model.exceptions.NoCumpleCondicionesDeTransformacionException;
import model.personajes.Personaje;
import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoPiccoloFortalecido extends EstadoTransformacion {
	
	private int porcentajeSaludGohanParaTransf = PORCENTAJE_VIDA_GOHAN_PROTECTOR;
	
	public EstadoPiccoloFortalecido()
	{
		this.nombre = NOMBRE_PICCOLO_PRIMERA_TRANSF;
		this.velocidad = VELOCIDAD_PICCOLO_PRIMERA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_PICCOLO_PRIMERA_TRANSF;
		this.poderDePelea = new Danio(PODER_PICCOLO_PRIMERA_TRANSF);
		this.siguienteEstado = new EstadoPiccoloProtector();
		this.kiParaTransformacion = new Ki(KI_PICCOLO_SEGUNDA_TRANF);
		this.rutaImagen = "file:src/vista/imagenes/piccoloFortalecido.png";
	}
	
	@Override
	public void transformar(Personaje personaje, Ki kiPersonaje){
		if (!this.cumpleCondicionesProtector(personaje)){
			throw new NoCumpleCondicionesDeTransformacionException();
		}
		super.transformar(personaje, kiPersonaje);
	}
	
	private boolean cumpleCondicionesProtector(Personaje piccolo){
		Personaje gohan = piccolo.getCompaniero(GOHAN_NOMBRE);
		return gohan.getPorcentajeSalud() < this.porcentajeSaludGohanParaTransf;
		
	}
}
