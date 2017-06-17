package personajes;

import static algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_PICCOLO;
import static algoBall.ConstantesDelJuego.KI_INICIAL;
import static algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_PICCOLO;
import static algoBall.ConstantesDelJuego.NOMBRE_PICCOLO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PICCOLO_NOMBRE;
import static algoBall.ConstantesDelJuego.PORCENTAJE_VIDA_GOHAN_PROTECTOR;
import static algoBall.ConstantesDelJuego.PROCENTAJE_DANIO_ATAQ_ESPECIAL_PICCOLO;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_PICCOLO;

import exceptions.NoCumpleCondicionesDeTransformacionException;
import exceptions.PersonajeInexistenteException;
import personajes.elementos.AtaqueEspecial;
import personajes.elementos.Ki;
import personajes.elementos.Salud;
import personajes.piccolo.EstadoPiccoloNormal;

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
		this.estadoTransformacionActual = new EstadoPiccoloNormal();
		this.movimientosRestantes = estadoTransformacionActual.getVelocidad();
		this.rutaImagen = "file:src/vista/imagenes/piccolo.png";
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