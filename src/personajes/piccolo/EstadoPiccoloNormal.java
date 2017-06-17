package personajes.piccolo;

import static algoBall.ConstantesDelJuego.DISTANCIA_PICCOLO_NORMAL;
import static algoBall.ConstantesDelJuego.NOMBRE_PICCOLO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_PICCOLO_NORMAL;
import static algoBall.ConstantesDelJuego.VELOCIDAD_PICCOLO_NORMAL;

import exceptions.NoCumpleCondicionesDeTransformacionException;
import exceptions.PersonajeInexistenteException;
import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;

public class EstadoPiccoloNormal extends EstadoTransformacion {
	
	public EstadoPiccoloNormal()
	{
		this.nombre = NOMBRE_TRANF_NORMAL;
		this.velocidad = VELOCIDAD_PICCOLO_NORMAL;
		this.distanciaDeAtaque = DISTANCIA_PICCOLO_NORMAL;
		this.poderDePelea = PODER_PICCOLO_NORMAL;
		this.siguienteEstado = new EstadoPiccoloFortalecido();
	}
	
	@Override
	public void transformar(){
		if(this.estadoTransformacionActual.getNombre() != NOMBRE_PICCOLO_PRIMERA_TRANSF ){
			super.transformar();
		}
		else if (this.cumpleCondicionesProtector()){
			super.transformar();
		}
		else{
			throw new NoCumpleCondicionesDeTransformacionException();
		}
	}
	
	public boolean cumpleCondicionesProtector(){
		Personaje gohan;
		try{
			gohan = this.equipo.getPersonaje("Gohan"); //Si Gohan esta muerto no se puede transformar
		}
		catch (PersonajeInexistenteException error){
			throw new NoCumpleCondicionesDeTransformacionException();
		}
		
		return (this.porcentajeVidaGohanParaProtector > gohan.getPorcentajeSalud());
		
	}
}
