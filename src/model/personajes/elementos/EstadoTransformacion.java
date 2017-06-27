package model.personajes.elementos;

import model.consumibles.Consumible;
import model.personajes.Personaje;

public abstract class EstadoTransformacion implements EstadoActividad {
	protected String nombre;
	protected int velocidad;
	protected int distanciaDeAtaque;
	protected Danio poderDePelea;
	protected EstadoActividad siguienteEstado = null;
	protected EstadoActividad anteriorEstado = null;
	protected Ki kiParaTransformacion = null;
	protected String rutaImagen;
	
	public void transformar(Personaje personaje, Ki kiPersonaje){
		kiPersonaje.restar(kiParaTransformacion);
		personaje.setEstado(this.siguienteEstado);
	}
	
	public void realizarAtaqueBasico(Personaje victima) {
		victima.recibirDanio(this.poderDePelea.getDanioContra(victima));
	}
	public void realizarAtaqueEspecial(Personaje victima, int porcentajeBonus) {
		victima.recibirDanio(this.poderDePelea.getDanioEspecialContra(victima, porcentajeBonus));
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
		this.poderDePelea = new Danio(poder);
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
		return poderDePelea.getDanio();
	}
	
	public EstadoActividad getEstadoSiguiente() {
		return siguienteEstado;
	}
	
	public EstadoActividad getEstadoAnterior() {
		if(this.anteriorEstado == null){
			return this;
		}
		return anteriorEstado;
	}
	
	public Ki getCostoTransformar(){
		return kiParaTransformacion;
	}
	
	public int getDanioAtaqueEspecial(int porcentajeBonus){
		return this.poderDePelea.obtenerDanioEspecial(porcentajeBonus);
	}
	
	public String getImagen(){
		return this.rutaImagen;
	}
	 
	public void aplicarKi(Personaje personaje, Ki kiASumar) {
		personaje.getKi().sumar(kiASumar);
	}

	@Override
	public void actualizarEstado(Personaje personaje) {};

	@Override
	public void capturarConsumible(Personaje personaje, Consumible consumible) {
		consumible.aplicarAPersonaje(personaje);
	}
	
	public boolean esTemporal(){
		return false;
	}

}