package model.personajes.gohan;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_GOHAN_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.KI_SEGUNDA_TRANF_GOHAN;
import static model.algoBall.ConstantesDelJuego.NOMBRE_GOHAN_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.PODER_GOHAN_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.PORCENTAJE_TOPE_VIDA_ATAQ_OCULTO_GOHAN;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_GOHAN_PRIMERA_TRANSF;

import model.exceptions.NoCumpleCondicionesDeTransformacionException;
import model.personajes.Personaje;
import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoGohanSuperSayajinFaseUno extends EstadoTransformacion 
{
	private int porcentajeSaludMinimoParaSegundaTranf = PORCENTAJE_TOPE_VIDA_ATAQ_OCULTO_GOHAN;
	
	public EstadoGohanSuperSayajinFaseUno()
	{
		this.nombre = NOMBRE_GOHAN_PRIMERA_TRANSF;
		this.velocidad = VELOCIDAD_GOHAN_PRIMERA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_GOHAN_PRIMERA_TRANSF;
		this.poderDePelea = new Danio(PODER_GOHAN_PRIMERA_TRANSF);
		this.siguienteEstado = new EstadoGohanSuperSayajinFaseDos();
		this.kiParaTransformacion = new Ki(KI_SEGUNDA_TRANF_GOHAN);
		this.rutaImagen = "file:src/vista/imagenes/gohanSuperSaiyan1.png";
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

