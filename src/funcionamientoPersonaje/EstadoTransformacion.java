package funcionamientoPersonaje;

import exceptions.YaNoPuedeEvolucionarException;

public class EstadoTransformacion implements Estado{
	private String nombre;
	private int velocidad;
	private int distanciaDeAtaque;
	private int poderDePelea;
	private EstadoTransformacion siguienteEstado = null;
	private Ki kiParaTransformacion = null;
	private int vidasAbsorvidasNecesariasParaTransformar;
	private int porcentajeVidaDeGohanNecesariaParaTransformar;
	private int porcentajeVidaDeCompanierosNecesariaParaTransformar;
	
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
	
	public void setVidasAbsorvidasNecesarias(int vidasNecesarias){
		vidasAbsorvidasNecesariasParaTransformar = vidasNecesarias;
	}
	
	public boolean seAbsorvieronVidasNecesarias(int vidasAbsorvidas){
		return (vidasAbsorvidas >= vidasAbsorvidasNecesariasParaTransformar);
	}
	
	public void setPorcetajeVidaDeGohanNecesaria(int vidaDeGohanNecesaria){
		porcentajeVidaDeGohanNecesariaParaTransformar = vidaDeGohanNecesaria;
	}
	
	public boolean vidaDeGohanEsMenorALaNecesariaParaTranformar(int porcentajeVidaDeGohan){
		return (porcentajeVidaDeGohan < porcentajeVidaDeGohanNecesariaParaTransformar);
	}
	
	public void setPorcetajeVidaDeCompanierosNecesaria(int vidaDeCompanierosNecesaria){
		porcentajeVidaDeCompanierosNecesariaParaTransformar = vidaDeCompanierosNecesaria;
	}
	
	public boolean vidaDeCompanierosEsMenorALaNecesariaParaTranformar(int porcentajeVidaCompaniero1, int porcentajeVidaCompaniero2){
		return (porcentajeVidaCompaniero1 < porcentajeVidaDeCompanierosNecesariaParaTransformar 
				&& porcentajeVidaCompaniero2 < porcentajeVidaDeCompanierosNecesariaParaTransformar);
	}

}
