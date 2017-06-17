package personajes.gohan;

import static algoBall.ConstantesDelJuego.DISTANCIA_GOHAN_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_GOHAN_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_GOHAN_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_GOHAN_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PORCENTAJE_TOPE_VIDA_ATAQ_OCULTO_GOHAN;

import exceptions.NoCumpleCondicionesDeTransformacionException;
import exceptions.YaNoPuedeEvolucionarException;
import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;
import personajes.elementos.Ki;

public class EstadoGohanSuperSayajinFaseUno extends EstadoTransformacion 
{

	private int porcentajeSaludMinimoParaSegundaTranf = PORCENTAJE_TOPE_VIDA_ATAQ_OCULTO_GOHAN;
	
	public EstadoGohanSuperSayajinFaseUno()
	{
		this.nombre = NOMBRE_GOHAN_PRIMERA_TRANSF;
		this.velocidad = VELOCIDAD_GOHAN_PRIMERA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_GOHAN_PRIMERA_TRANSF;
		this.poderDePelea = PODER_GOHAN_PRIMERA_TRANSF;
		this.siguienteEstado = new EstadoGohanSuperSayajinFaseDos();
	}
	
	@Override
	public void transformar(Personaje personaje, Ki kiPersonaje) {
		if(!this.companierosTienenMinimoPorcentajeDeSalud(personaje)){
			throw new NoCumpleCondicionesDeTransformacionException();
		}
		super.transformar(personaje, kiPersonaje);
	}
	
	private boolean companierosTienenMinimoPorcentajeDeSalud(Personaje personaje){
		return personaje.mayorPorcentajeSaludDeCompanieros() < porcentajeSaludMinimoParaSegundaTranf;
	}
	 

}

