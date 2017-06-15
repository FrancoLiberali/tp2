package personajes;

import static algoBall.ConstantesDelJuego.DISTANCIA_GOHAN_NORMAL;
import static algoBall.ConstantesDelJuego.DISTANCIA_GOHAN_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.DISTANCIA_GOHAN_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.GOHAN_NOMBRE;
import static algoBall.ConstantesDelJuego.GOKU_NOMBRE;
import static algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_GOHAN;
import static algoBall.ConstantesDelJuego.KI_GOHAN_PRIMERA_TRANF;
import static algoBall.ConstantesDelJuego.KI_INICIAL;
import static algoBall.ConstantesDelJuego.KI_SEGUNDA_TRANF_GOHAN;
import static algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_GOHAN;
import static algoBall.ConstantesDelJuego.NOMBRE_GOHAN_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_GOHAN_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.PICCOLO_NOMBRE;
import static algoBall.ConstantesDelJuego.PODER_GOHAN_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_GOHAN_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_GOHAN_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.PORCENTAJE_TOPE_VIDA_ATAQ_OCULTO_GOHAN;
import static algoBall.ConstantesDelJuego.PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOHAN;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOHAN;
import static algoBall.ConstantesDelJuego.VELOCIDAD_GOHAN_NORMAL;
import static algoBall.ConstantesDelJuego.VELOCIDAD_GOHAN_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_GOHAN_SEGUNDA_TRANSF;

import exceptions.NoCumpleCondicionesDeTransformacionException;
import exceptions.PersonajeInexistenteException;
import funcionamientoPersonaje.elementos.AtaqueEspecial;
import funcionamientoPersonaje.elementos.EstadoTransformacion;
import funcionamientoPersonaje.elementos.Ki;
import funcionamientoPersonaje.elementos.Salud;

public class Gohan extends Personaje 
{	
	private int porcentajeVidaNecesariasParaSegundaTransformacion;
	public Gohan()
	{
		this.nombre = GOHAN_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_GOHAN);
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_GOHAN, KI_ATQ_ESPECIAL_GOHAN);
		this.estadoTransformacionActual = setEstadoNormal();
		this.movimientosRestantes = estadoTransformacionActual.getVelocidad();
		this.ataqueEspecial.setPorcentaje(PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOHAN);
		this.porcentajeVidaNecesariasParaSegundaTransformacion = PORCENTAJE_TOPE_VIDA_ATAQ_OCULTO_GOHAN;
	}
	
	
	@Override
	public EstadoTransformacion setEstadoNormal()
	{
		String nombre = NOMBRE_TRANF_NORMAL;
		int velocidad = VELOCIDAD_GOHAN_NORMAL;
		int distancia = DISTANCIA_GOHAN_NORMAL;
		int poder = PODER_GOHAN_NORMAL;
		EstadoTransformacion normal = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		normal.setSiguienteEstado(siguiente, KI_GOHAN_PRIMERA_TRANF);
		return normal;
	}
	
	
	@Override 
	public EstadoTransformacion setPrimerEstadoTransformacion() {
		String nombre = NOMBRE_GOHAN_PRIMERA_TRANSF;
		int velocidad = VELOCIDAD_GOHAN_PRIMERA_TRANSF;
		int distancia = DISTANCIA_GOHAN_PRIMERA_TRANSF;
		int poder = PODER_GOHAN_PRIMERA_TRANSF;
		EstadoTransformacion primeraTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setSegundoEstadoTransformacion();
		primeraTranf.setSiguienteEstado(siguiente, KI_SEGUNDA_TRANF_GOHAN);
		return primeraTranf;
	}
	
	
	@Override 
	public EstadoTransformacion setSegundoEstadoTransformacion() {
		String nombre = NOMBRE_GOHAN_SEGUNDA_TRANSF;
		int velocidad = VELOCIDAD_GOHAN_SEGUNDA_TRANSF;
		int distancia = DISTANCIA_GOHAN_SEGUNDA_TRANSF;
		int poder = PODER_GOHAN_SEGUNDA_TRANSF;
		EstadoTransformacion segundaTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);

		return segundaTranf;
	}
	
	@Override
	public void transformar(){
		if  ((this.getEstadoActividad().getNombre() == NOMBRE_GOHAN_PRIMERA_TRANSF)){
			
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