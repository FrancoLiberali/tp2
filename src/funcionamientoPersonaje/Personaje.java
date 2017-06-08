package funcionamientoPersonaje;

import exceptions.CasilleroOcupadoException;
import exceptions.FueraDelTableroException;
import exceptions.NoQuedanMovimientosException;
import funcionamientoTablero.Posicion;

public class Personaje 
{
	private Posicion posicion;
	// private int velocidad;
	private String nombre;
	private int movimientosRestantes;
	private int ki;
	private int salud;
	private Estado estadoActividad;
	private EstadoTransformacion estadoTransformacion;
	
	
	
	public Personaje(String nombre)
	{
		this.nombre = nombre;
		this.ki = 0;
		this.estadoTransformacion = new EstadoTransformacion();
		this.estadoActividad = new EstadoActividad();
		
		
	}
		
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getKi()
	{
		return this.ki;
	}
	
	public Posicion getPosicion()
	{
		return this.posicion;
	}
	
	public void setPosicion(Posicion pos) 
	{
		this.posicion = pos;
		
	}
	public void setVelocidad( int velocidad)
	{
		this.estadoTransformacion.setVelocidad(velocidad);
		//this.velocidad = velocidad;
		this.movimientosRestantes = this.estadoTransformacion.getVelocidad();
	}
	
	public int getVelocidad()
	{
		return (this.estadoTransformacion.getVelocidad());
		//return this.velocidad;
	}
	
	public void moverIzquierda(){
		Posicion posicion_nueva = this.posicion.darIzquierda();
		this.mover(posicion_nueva);
	}
	public void moverAbajo(){
		Posicion posicion_nueva = this.posicion.darAbajo();
		this.mover(posicion_nueva);
	}
	public void moverDerecha(){
		Posicion posicion_nueva = this.posicion.darDerecha();
		this.mover(posicion_nueva);
	}
	public void moverArriba(){
		Posicion posicion_nueva = this.posicion.darArriba();
		this.mover(posicion_nueva);
	}
	
	public void mover(Posicion nuevaPosicion){
		if (this.movimientosRestantes == 0){
			throw new NoQuedanMovimientosException();
		}
			
		try {
			Posicion posicion_anterior = this.posicion;
			nuevaPosicion.ponerEnTablero(this);
			posicion_anterior.vaciarTableroEnPos();
			this.movimientosRestantes = this.movimientosRestantes - 1;
		}
		catch (CasilleroOcupadoException error){
			/*cancela movimiento (mas adelante agregar mensaje a usuario)*/
		}
		catch (FueraDelTableroException error){
			/*cancela movimiento (mas adelante agregar mensaje a usuario)*/
		}
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}
}
