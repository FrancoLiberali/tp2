package personajes.elementos;

import exceptions.YaNoPuedeEvolucionarException;
import personajes.Personaje;
import tablero.Posicion;

public class EstadoTransformacion implements EstadoActividad {
	protected String nombre;
	protected int velocidad;
	protected int distanciaDeAtaque;
	protected int poderDePelea;
	protected EstadoActividad siguienteEstado = null;
	protected Ki kiParaTransformacion = null;
	
	public void reducirTurnos() {};

	public void transformar(Personaje personaje) {
		personaje.setEstado(this.siguienteEstado);
	}
	
	public EstadoActividad transformar(Ki kiPersonaje){
		if (this.siguienteEstado == null){
			throw new YaNoPuedeEvolucionarException();
		}
		kiPersonaje.restar(kiParaTransformacion);
		return this.siguienteEstado;
	}
	
	protected void atacar(Personaje victima, int danio){
		victima.recibirDanio(danio, this.getPoderDePelea());
	
	}
	public void realizarAtaqueBasico(Personaje victima) {
		this.atacar(victima, this.poderDePelea);
		
	}
	public void realizarAtaqueEspecial(Personaje victima, int porcentajeBonus) {
		this.atacar(victima, this.poderDePelea + this.poderDePelea * porcentajeBonus /100);
		
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void setVelocidad(int velocidad)
	{
		this.velocidad = velocidad;
	}
	
	public void setPoderDePelea(int poder)
	{
		this.poderDePelea = poder;
	}
	
	public void setDistanciaDeAtaque(int distancia)
	{
		this.distanciaDeAtaque = distancia;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public int getDistanciaDeAtaque() {
		return distanciaDeAtaque;
	}
	
	public int getPoderDePelea() {
		return poderDePelea;
	}
	
	public void aplicarKi(Personaje personaje, int cantidad) {
		personaje.getKi().sumar(cantidad);
	}

	@Override
	public void aplicarMovimiento(Personaje personaje, Posicion nuevaPosicion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realizarAtaqueEspecial(Personaje atacante, Personaje victima) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSiguienteEstado(EstadoActividad estadoTransformacionActual, int i) {
		// TODO Auto-generated method stub
		
	}

}