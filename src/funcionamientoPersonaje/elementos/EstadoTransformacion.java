package funcionamientoPersonaje.elementos;

import exceptions.FueraDeRangoException;
import exceptions.IntentandoAtacarAUnCompanieroException;
import exceptions.NoEstaEnEstadoChocolateException;
import exceptions.YaNoPuedeEvolucionarException;
import funcionamientoPersonaje.personajes.Personaje;
import funcionamientoTablero.Posicion;

public class EstadoTransformacion implements EstadoActividad{
	private String nombre;
	private int velocidad;
	private int distanciaDeAtaque;
	private int poderDePelea;
	private EstadoActividad siguienteEstado = null;
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
	
	public void setSiguienteEstado(EstadoActividad siguiente, int kiNecesario){
		this.siguienteEstado = siguiente;
		this.kiParaTransformacion = new Ki(kiNecesario);		
	}
	
	public void reducirTurnos()
	{
		throw new NoEstaEnEstadoChocolateException();
	}
	public EstadoActividad transformar(Ki kiPersonaje){
		if (this.siguienteEstado == null){
			throw new YaNoPuedeEvolucionarException();
		}
		kiPersonaje.restar(kiParaTransformacion);
		return this.siguienteEstado;
	}
	
	protected void atacar(Posicion posicionVictima, int danio){
		Personaje personajeAAtacar = posicionVictima.getPersonaje();
		personajeAAtacar.recibirDanio(danio, this.getPoderDePelea());
	
	}
	public void realizarAtaqueBasico(Posicion posicionVictima) {
		this.atacar(posicionVictima, this.poderDePelea);
		
	}
	public void realizarAtaqueEspecial(Posicion posicionVictima, int porcentajeBonus) {
		this.atacar(posicionVictima, this.poderDePelea + this.poderDePelea * porcentajeBonus /100);
		
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

	public void aplicarKi(Personaje personaje, int cantidad) {
		personaje.ejecutarAumentoDeKi(cantidad);
	}

	@Override
	public void aplicarMovimiento(Personaje personaje, Posicion nuevaPosicion) {
		// TODO Auto-generated method stub
		
	}

}