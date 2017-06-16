package personajes;

import static algoBall.ConstantesDelJuego.CELL_CANT_ABSORVER_VIDA_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.CELL_CANT_ABSORVER_VIDA_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.CELL_NOMBRE;
import static algoBall.ConstantesDelJuego.DISTANCIA_CELL_NORMAL;
import static algoBall.ConstantesDelJuego.DISTANCIA_CELL_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.DISTANCIA_CELL_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_CELL;
import static algoBall.ConstantesDelJuego.KI_CELL_PRIMERA_TRANF;
import static algoBall.ConstantesDelJuego.KI_CELL_SEGUNDA_TRANF;
import static algoBall.ConstantesDelJuego.KI_INICIAL;
import static algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_CELL;
import static algoBall.ConstantesDelJuego.NOMBRE_CELL_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_CELL_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_CELL_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_CELL_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_CELL_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_CELL;
import static algoBall.ConstantesDelJuego.VELOCIDAD_CELL_NORMAL;
import static algoBall.ConstantesDelJuego.VELOCIDAD_CELL_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_CELL_SEGUNDA_TRANSF;

import exceptions.NoCumpleCondicionesDeTransformacionException;
import funcionamientoPersonaje.elementos.AtaqueEspecial;
import funcionamientoPersonaje.elementos.EstadoActividad;
import funcionamientoPersonaje.elementos.EstadoTransformacion;
import funcionamientoPersonaje.elementos.Ki;
import funcionamientoPersonaje.elementos.Salud;
import javafx.scene.image.Image;

public class Cell extends Personaje 
{	
	private int vidasAbsorvidas = 0;
	private int vidasNecesariasSegundaTransf = CELL_CANT_ABSORVER_VIDA_SEGUNDA_TRANSF;
	private int vidasNecesariasPrimeraTransf = CELL_CANT_ABSORVER_VIDA_PRIMERA_TRANSF;
	
	public Cell()
	{
		this.nombre = CELL_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_CELL);
		this.estadoTransformacionActual = setEstadoNormal();
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_CELL, KI_ATQ_ESPECIAL_CELL);
		this.imagen = new Image("file:src/vista/imagenes/cell.png");
		
	}
	
	
	
	public EstadoActividad setEstadoNormal()
	{
		String nombre = NOMBRE_TRANF_NORMAL;
		int velocidad = VELOCIDAD_CELL_NORMAL;
		int distancia = DISTANCIA_CELL_NORMAL;
		int poder = PODER_CELL_NORMAL;
		EstadoActividad normal = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		normal.setSiguienteEstado(siguiente, KI_CELL_PRIMERA_TRANF);
		

		return normal;
	}
	
	@Override 
	public EstadoTransformacion setPrimerEstadoTransformacion() {
		String nombre = NOMBRE_CELL_PRIMERA_TRANSF;
		int velocidad = VELOCIDAD_CELL_PRIMERA_TRANSF;
		int distancia = DISTANCIA_CELL_PRIMERA_TRANSF;
		int poder = PODER_CELL_PRIMERA_TRANSF;
		EstadoTransformacion primeraTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setSegundoEstadoTransformacion();
		primeraTranf.setSiguienteEstado(siguiente, KI_CELL_SEGUNDA_TRANF);
		return primeraTranf;
	}
	
	@Override 
	public EstadoTransformacion setSegundoEstadoTransformacion() {
		String nombre = NOMBRE_CELL_SEGUNDA_TRANSF;
		int velocidad = VELOCIDAD_CELL_SEGUNDA_TRANSF;
		int distancia = DISTANCIA_CELL_SEGUNDA_TRANSF;
		int poder = PODER_CELL_SEGUNDA_TRANSF;
		EstadoTransformacion segundaTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		return segundaTranf;
	}
	
	@Override
	public void realizarAtaqueEspecial(Personaje victima){
		super.realizarAtaqueBasico(victima);
		vidasAbsorvidas = vidasAbsorvidas + 1;
		salud.aumentar(this.estadoTransformacionActual.getPoderDePelea());
		
	}
	
	@Override
	public void transformar(){
		if (seAbsorvieronVidasNecesarias()){
			super.transformar();
		}
		else{
			throw new NoCumpleCondicionesDeTransformacionException();
		}
		
	}
	
	private boolean seAbsorvieronVidasNecesarias(){
		boolean seAbsorvieron = false;
		String nombre = this.estadoTransformacionActual.getNombre();
		if (nombre == NOMBRE_TRANF_NORMAL){
			seAbsorvieron = this.vidasAbsorvidas >= vidasNecesariasPrimeraTransf;
		}
		else if (nombre == NOMBRE_CELL_PRIMERA_TRANSF){
			seAbsorvieron = this.vidasAbsorvidas >= vidasNecesariasSegundaTransf;
		
		}
		return seAbsorvieron;
	}
}