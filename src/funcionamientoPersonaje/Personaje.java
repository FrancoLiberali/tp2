package funcionamientoPersonaje;

import algoBall.Agrupacion;
import exceptions.CasilleroOcupadoException;
import exceptions.FueraDeRangoException;
import exceptions.FueraDelTableroException;
import exceptions.KiInsuficienteException;
import exceptions.NoQuedanMovimientosException;
import exceptions.YaNoPuedeEvolucionarException;
import funcionamientoTablero.Posicion;

public class Personaje 
{
	private Posicion posicion;
	private String nombre;
	private int movimientosRestantes;
	private Ki ki;
	private int salud;
	private Estado estadoActividad;
	private EstadoTransformacion estadoTransformacionActual;
	private Agrupacion agrupacion;
	
	
	
	public Personaje(String nombre, EstadoTransformacion estadoInicial)
	{
		this.nombre = nombre;
		this.ki = new Ki(0);
		this.estadoTransformacionActual = estadoInicial;
		this.movimientosRestantes = estadoInicial.getVelocidad();
		this.estadoActividad = new EstadoActividad();
		
	}
		
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getKi()
	{
		return ki.getKi();
	}
	
	public void aumentarKi(int cantidad){
		ki.sumar(cantidad);
	}
	
	public Posicion getPosicion()
	{
		return this.posicion;
	}
	
	public void setPosicion(Posicion pos) 
	{
		this.posicion = pos;
		
	}
	
	public int getVelocidad()
	{
		return (this.estadoTransformacionActual.getVelocidad());
	}
	
	public int getPoderDePelea()
	{
		return (this.estadoTransformacionActual.getPoderDePelea());
	}
	public int getDistanciaDeAtaque()
	{
		return (this.estadoTransformacionActual.getDistanciaDeAtaque());
	}
	
	public void transformar(){
		try{
			this.estadoTransformacionActual = this.estadoTransformacionActual.transformar(this.ki);
		}
		catch (YaNoPuedeEvolucionarException error){
			/*cancela evolucion (mas adelante agregar mensaje a usuario)*/
		}
		catch (KiInsuficienteException error){
			/*cancela evolucion (mas adelante agregar mensaje a usuario)*/
		}
	}
	
	public EstadoTransformacion getEstadoTransformacion(){
		return estadoTransformacionActual;
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

	public void atacar(Posicion posicionVictima){
		if (!this.posicion.dentroDelRango(posicionVictima, this.getDistanciaDeAtaque())){
			throw new FueraDeRangoException();
		}
		
		Personaje personajeAAtacar = posicionVictima.getPersonaje();
		personajeAAtacar.recibirDanio(this.estadoTransformacionActual.getPoderDePelea());
		
	}

	public void recibirDanio(int poderDePelea){
		this.salud = this.salud - poderDePelea;
		if (this.salud <= 0){
			this.agrupacion.eliminar(this);
		}
	}
	public void setAgrupacion(Agrupacion agrupacion){
		this.agrupacion = agrupacion;
	}
	
	public void reestablecer(){
		/*deja todo listo para el siguiente turno*/
		movimientosRestantes = this.getVelocidad();
		ki.sumar(5);
	}
	
	public void prohibirMovimientos(){
		movimientosRestantes = 0;
	}

}
