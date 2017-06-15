package personajes;

import static algoBall.ConstantesDelJuego.DISTANCIA_PICCOLO_NORMAL;
import static algoBall.ConstantesDelJuego.DISTANCIA_PICCOLO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.DISTANCIA_PICCOLO_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_PICCOLO;
import static algoBall.ConstantesDelJuego.KI_INICIAL;
import static algoBall.ConstantesDelJuego.KI_PICCOLO_PRIMERA_TRANF;
import static algoBall.ConstantesDelJuego.KI_PICCOLO_SEGUNDA_TRANF;
import static algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_PICCOLO;
import static algoBall.ConstantesDelJuego.NOMBRE_PICCOLO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_PICCOLO_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.PICCOLO_NOMBRE;
import static algoBall.ConstantesDelJuego.PODER_PICCOLO_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_PICCOLO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_PICCOLO_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.PORCENTAJE_VIDA_GOHAN_PROTECTOR;
import static algoBall.ConstantesDelJuego.PROCENTAJE_DANIO_ATAQ_ESPECIAL_PICCOLO;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_PICCOLO;
import static algoBall.ConstantesDelJuego.VELOCIDAD_PICCOLO_NORMAL;
import static algoBall.ConstantesDelJuego.VELOCIDAD_PICCOLO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_PICCOLO_SEGUNDA_TRANSF;

import exceptions.NoCumpleCondicionesDeTransformacionException;
import exceptions.PersonajeInexistenteException;
import funcionamientoPersonaje.elementos.AtaqueEspecial;
import funcionamientoPersonaje.elementos.EstadoTransformacion;
import funcionamientoPersonaje.elementos.Ki;
import funcionamientoPersonaje.elementos.Salud;

public class Piccolo extends Personaje 
{	
	private int porcentajeVidaGohanParaProtector = PORCENTAJE_VIDA_GOHAN_PROTECTOR;
	
	public Piccolo()
	{
		this.nombre = PICCOLO_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_PICCOLO);
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_PICCOLO, KI_ATQ_ESPECIAL_PICCOLO);
		this.ataqueEspecial.setPorcentaje(PROCENTAJE_DANIO_ATAQ_ESPECIAL_PICCOLO);
		this.estadoTransformacionActual = setEstadoNormal();
		this.movimientosRestantes = estadoTransformacionActual.getVelocidad();
	}
	
	@Override
	public EstadoTransformacion setEstadoNormal()
	{
		String nombre = NOMBRE_TRANF_NORMAL;
		int velocidad = VELOCIDAD_PICCOLO_NORMAL;
		int distancia = DISTANCIA_PICCOLO_NORMAL;
		int poder = PODER_PICCOLO_NORMAL;
		EstadoTransformacion normal = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		normal.setSiguienteEstado(siguiente, KI_PICCOLO_PRIMERA_TRANF);
	

		return normal;
	}
	
	@Override 
	public EstadoTransformacion setPrimerEstadoTransformacion() {
		String nombre = NOMBRE_PICCOLO_PRIMERA_TRANSF;
		int velocidad = VELOCIDAD_PICCOLO_PRIMERA_TRANSF;
		int distancia = DISTANCIA_PICCOLO_PRIMERA_TRANSF;
		int poder = PODER_PICCOLO_PRIMERA_TRANSF;
		EstadoTransformacion primeraTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setSegundoEstadoTransformacion();
		primeraTranf.setSiguienteEstado(siguiente, KI_PICCOLO_SEGUNDA_TRANF);
		return primeraTranf;
	}
	
	@Override 
	public EstadoTransformacion setSegundoEstadoTransformacion() {
		String nombre = NOMBRE_PICCOLO_SEGUNDA_TRANSF;
		int velocidad = VELOCIDAD_PICCOLO_SEGUNDA_TRANSF;
		int distancia = DISTANCIA_PICCOLO_SEGUNDA_TRANSF;
		int poder = PODER_PICCOLO_SEGUNDA_TRANSF;
		EstadoTransformacion segundaTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);

		return segundaTranf;
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