package funcionamientoPersonaje;

import exceptions.YaNoPuedeEvolucionarException;

public class EstadoTransformacion implements Estado{
	private String nombre;
	private int velocidad;
	private int distanciaDeAtaque;
	private int poderDePelea;
	private EstadoTransformacion siguienteEstado = null;
	private Ki kiParaTransformacion = null;
	private int vidasNecesariasParaTransformar;
	
	public EstadoTransformacion (String nombre, int poder, int distancia, int velocidad){
		this.nombre = nombre;
		this.velocidad = velocidad;
		this.distanciaDeAtaque = distancia;
		this.poderDePelea = poder;
	}
	
	public void setSiguienteEstado(EstadoTransformacion siguiente, int kiNecesario){
		this.siguienteEstado = siguiente;
		this.kiParaTransformacion = new Ki(kiNecesario);		
	}
	
	public EstadoTransformacion transformar(Ki kiPersonaje){
		if (this.siguienteEstado == null){
			throw new YaNoPuedeEvolucionarException();
		}
		kiPersonaje.restar(kiParaTransformacion);
		return this.siguienteEstado;
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
	
	public void setVidasNecesarias(int vidasNecesarias){
		vidasNecesariasParaTransformar = vidasNecesarias;
	}
	
	public boolean seAbsorvieronVidasNecesarias(int vidasAbsorvidas){
		return (vidasAbsorvidas >= vidasNecesariasParaTransformar);
	}

	
	
}
