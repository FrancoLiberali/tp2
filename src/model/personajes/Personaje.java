package model.personajes;


import static model.algoBall.ConstantesDelJuego.KI_POR_TURNO;

import java.util.Hashtable;

import model.algoBall.Equipo;
import model.algoBall.Posicionable;
import model.consumibles.Consumible;
import model.exceptions.FueraDeRangoException;
import model.exceptions.IntentandoAtacarAUnCompanieroException;
import model.exceptions.NoTienesAtaquesRestantesException;
import model.personajes.elementos.AtaqueEspecial;
import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoActividad;
import model.personajes.elementos.EstadoInactivoConChocolate;
import model.personajes.elementos.Ki;
import model.personajes.elementos.Salud;
import model.tablero.Posicion;


public abstract class Personaje implements Posicionable
{
	protected Posicion posicion;
	protected String nombre;
	protected Ki ki;
	protected Salud salud;
	protected EstadoActividad estadoTransformacionActual;
	protected Equipo equipo;
	protected AtaqueEspecial ataqueEspecial;
	protected String rutaImagen;
	
	public void setAtaqueEspecial(AtaqueEspecial ataqueEspecial)
	{
		this.ataqueEspecial = ataqueEspecial;
	}
	
	public void setPosicion(Posicion pos) 
	{
		this.posicion = pos;	
	}
	
	public void setEquipo(Equipo equipo){
		this.equipo = equipo;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getSalud() {
		return this.salud.getSalud();
	}
	
	public int getPorcentajeSalud(){
		return this.salud.getPorcentajeSalud();
	}
	
	public int getKiCantidad()
	{
		return ki.getKi();
	}
	
	public Ki getKi()
	{
		return this.ki;
	}
	
	public Posicion getPosicion()
	{
		return this.posicion;
	}
	
	public int getVelocidad()
	{
		return this.estadoTransformacionActual.getVelocidad();
	}
	
	public int getPoderDePelea()
	{
		return this.estadoTransformacionActual.getPoderDePelea();
	}
	public int getDistanciaDeAtaque()
	{
		return this.estadoTransformacionActual.getDistanciaDeAtaque();
	}
	
	public void aumentarKi(Ki kiPorTurno){
		this.estadoTransformacionActual.aplicarKi(this, kiPorTurno);
	}
	
	public void transformar()
	{
		int velocidadAnterior = this.getVelocidad();
		this.estadoTransformacionActual.transformar(this, this.ki);
		this.actualizarMovimientosRestantes(velocidadAnterior);
	}
	
	public void mover(Posicion nuevaPosicion){
		nuevaPosicion.ocupar(this);
		posicion.vaciar();
		posicion = nuevaPosicion;
	}
	
	protected void verificarAtaque(Personaje victima)
	{	
		if (!this.posicion.dentroDelRango(victima.getPosicion(), this.getDistanciaDeAtaque())){
			throw new FueraDeRangoException();
		}
		
		if (this.equipo.esAliado(victima.getNombre())){
			throw new IntentandoAtacarAUnCompanieroException();
		}
		if(this.equipo.getAtaquesRestantes() == 0){
			throw new NoTienesAtaquesRestantesException();
			
		}
		
		
	}
	public void realizarAtaqueBasico(Personaje victima){
		this.verificarAtaque(victima);
		this.estadoTransformacionActual.realizarAtaqueBasico(victima);
		this.equipo.restarAtaqueRestates();
		
		
	}

	public void realizarAtaqueEspecial(Personaje victima)
	{		
		this.verificarAtaque(victima);
		this.estadoTransformacionActual.realizarAtaqueEspecial(victima,
				this.ataqueEspecial.getPorcentaje(this.ki));
		this.equipo.restarAtaqueRestates();
	}

	public void recibirDanio(Danio danio){
		this.salud.disminuir(new Salud(danio.getDanio()));
		
		if (this.salud.esCero()){
			this.equipo.eliminar(this);
		}
	}
	
	public void reducirSalud(Salud cantidad)
	{
		this.salud.disminuir(cantidad);
	}
	
	public void reestablecer(){
		/*deja todo listo para el siguiente turno*/
		this.estadoTransformacionActual.actualizarEstado(this);
		this.aumentarKi(new Ki(KI_POR_TURNO));
	}	
	
	private void actualizarMovimientosRestantes(int velocidadAnterior)
	{
		equipo.actualizarMovimientosRestantes(this, velocidadAnterior, this.getVelocidad());
	}
	
	public EstadoActividad getEstado() {
		return this.estadoTransformacionActual;
	}

	public void regenerarSalud(Salud plusVida) {
		this.salud.aumentar(plusVida);
	}
	
	public void agarrarConsumible(Consumible consumible)
	{
		this.estadoTransformacionActual.capturarConsumible(this, consumible);
	}

	public void setEstado(EstadoActividad estado) {
		this.estadoTransformacionActual = estado;
	}
	
	public String getImagen(){
		return this.estadoTransformacionActual.getImagen();
	}

	public int mayorPorcentajeSaludDeCompanieros() {
		return equipo.mayorPorcentajeSaludDeCompanierosDe(this);
	}
	
	public Personaje getCompaniero(String nombre)
	{
		return this.equipo.getPersonaje(nombre);
	}
	
	public void actualizarEstado()
	{
		this.estadoTransformacionActual.actualizarEstado(this);
	}
	
	public boolean estaConvertidoAChocolate() {
		return this.estadoTransformacionActual.getClass() == EstadoInactivoConChocolate.class;
	}
	
	@Override
	public boolean equals(Object otroPersonaje) 
	{
		if (this == otroPersonaje){
				return true;
		}
		if (!(otroPersonaje instanceof Posicion)){
				return false;
		}
		Personaje otroPsje = (Personaje)otroPersonaje;
		return this.getNombre() == otroPsje.getNombre();
	}

	@Override
	public int hashCode() 
	{
	    return 0;
	}
	
	public Hashtable<String, Integer> darCaracteriticas() {
		Hashtable<String, Integer> caracteristicas = new Hashtable<String, Integer>();
		caracteristicas.put("Ki", this.getKiCantidad());
		caracteristicas.put("Vel", this.getVelocidad());
		caracteristicas.put("DdA", this.getDistanciaDeAtaque());
		caracteristicas.put("PdP", this.getPoderDePelea());
		return caracteristicas;
	}

	public Hashtable<String, Integer> darCaracteriticasTransormacion() {
		Hashtable<String, Integer> caracteristicas = new Hashtable<String, Integer>();
		//caracteristicas.put("Ki", estadoTransformacionActual.getEstadoSiguiente().); ki necesario
		caracteristicas.put("Vel", estadoTransformacionActual.getEstadoSiguiente().getVelocidad());
		caracteristicas.put("DdA", estadoTransformacionActual.getEstadoSiguiente().getDistanciaDeAtaque());
		caracteristicas.put("PdP", estadoTransformacionActual.getEstadoSiguiente().getPoderDePelea());
		return caracteristicas;
	}
}
