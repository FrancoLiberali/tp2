package funcionamientoPersonaje.elementos;

import exceptions.YaNoPuedeEvolucionarException;
import personajes.Personaje;
import tablero.Posicion;

public class EstadoTransformacion implements EstadoActividad{
	private String nombre;
	private int velocidad;
	private int distanciaDeAtaque;
	private int poderDePelea;
	private EstadoActividad siguienteEstado = null;
	private Ki kiParaTransformacion = null;
	
	public EstadoTransformacion (String nombre, int poder, int distancia, int velocidad){
		this.nombre = nombre;
		this.velocidad = velocidad;
		this.distanciaDeAtaque = distancia;
		this.poderDePelea = poder;
	}
	
	public void setSiguienteEstado(EstadoActividad siguiente, int kiNecesario){
		this.siguienteEstado = siguiente;
		this.kiParaTransformacion = new Ki(kiNecesario);		
	}
	
	public void reducirTurnos()
	{}
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
		personaje.ejecutarAumentoDeKi(cantidad);
	}

	@Override
	public void aplicarMovimiento(Personaje personaje, Posicion nuevaPosicion) {
		// TODO Auto-generated method stub
		
	}

}