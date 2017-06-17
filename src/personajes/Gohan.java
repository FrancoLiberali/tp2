package personajes;

import static algoBall.ConstantesDelJuego.GOHAN_NOMBRE;
import static algoBall.ConstantesDelJuego.GOKU_NOMBRE;
import static algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_GOHAN;
import static algoBall.ConstantesDelJuego.KI_INICIAL;
import static algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_GOHAN;
import static algoBall.ConstantesDelJuego.NOMBRE_GOHAN_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PICCOLO_NOMBRE;
import static algoBall.ConstantesDelJuego.PORCENTAJE_TOPE_VIDA_ATAQ_OCULTO_GOHAN;
import static algoBall.ConstantesDelJuego.PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOHAN;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOHAN;

import exceptions.NoCumpleCondicionesDeTransformacionException;
import exceptions.PersonajeInexistenteException;
import personajes.elementos.AtaqueEspecial;
import personajes.elementos.Ki;
import personajes.elementos.Salud;
import personajes.gohan.EstadoGohanNormal;

public class Gohan extends Personaje 
{	
	private int porcentajeVidaNecesariasParaSegundaTransformacion;
	public Gohan()
	{
		this.nombre = GOHAN_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_GOHAN);
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_GOHAN, KI_ATQ_ESPECIAL_GOHAN);
		this.estadoTransformacionActual = new EstadoGohanNormal();
		this.movimientosRestantes = estadoTransformacionActual.getVelocidad();
		this.ataqueEspecial.setPorcentaje(PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOHAN);
		this.porcentajeVidaNecesariasParaSegundaTransformacion = PORCENTAJE_TOPE_VIDA_ATAQ_OCULTO_GOHAN;
	}
	
	
	@Override
	public void transformar(){
		if  ((this.getEstado().getNombre() == NOMBRE_GOHAN_PRIMERA_TRANSF)){
			
			super.transformar();
		}
		else if (this.puedaRealizarSegundaTransformacion()){
			
			super.transformar();
		}
		else{
			throw new NoCumpleCondicionesDeTransformacionException();
		}
	}
	
	private boolean puedaRealizarSegundaTransformacion(){
		int porcentajeVidaGoku = obtenerPorcentajeDeVidaDe(GOKU_NOMBRE);
		int porcentajeVidaPiccolo = obtenerPorcentajeDeVidaDe(PICCOLO_NOMBRE);
		if (porcentajeVidaGoku < this.porcentajeVidaNecesariasParaSegundaTransformacion
				|| porcentajeVidaPiccolo < porcentajeVidaNecesariasParaSegundaTransformacion){
			return true;
		}
		return false;
	}
	
	private int obtenerPorcentajeDeVidaDe(String nombrePersonaje){
		try{
			Personaje personaje = this.equipo.getPersonaje(nombrePersonaje);
			return personaje.getPorcentajeSalud();
		}
		catch (PersonajeInexistenteException error){
			/*mensaje al usuario*/
			return 0;
		}
	}
	
}