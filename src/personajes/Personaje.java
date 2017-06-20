package personajes;


import static algoBall.ConstantesDelJuego.REDUCCION_DE_ATAQUE;
import static algoBall.ConstantesDelJuego.KI_POR_TURNO;

import java.io.File;
import java.util.Hashtable;

import algoBall.Equipo;
import algoBall.Posicionable;
import consumibles.Consumible;
import exceptions.FueraDeRangoException;
import exceptions.IntentandoAtacarAUnCompanieroException;
import exceptions.NoTienesAtaquesRestantesException;
import exceptions.PersonajeInexistenteException;
import javafx.scene.media.AudioClip;
import personajes.elementos.AtaqueEspecial;
import personajes.elementos.EstadoActividad;
import personajes.elementos.EstadoInactivoConChocolate;
import personajes.elementos.Ki;
import personajes.elementos.Salud;
import tablero.Posicion;


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
	
	public void aumentarKi(int cantidad){
		this.estadoTransformacionActual.aplicarKi(this, cantidad);
	}
	
	public void transformar()
	{
		File archivo = new File("src/vista/musica/auraOn.mp3");
		AudioClip sonidoAtaque = new AudioClip(archivo.toURI().toString());
		
		int velocidadAnterior = this.getVelocidad();
		this.estadoTransformacionActual.transformar(this, this.ki);
		sonidoAtaque.play();
		this.actualizarMovimientosRestantes(velocidadAnterior);
		
	}
	
	protected void verificarAtaque(Personaje victima)
	{	
		if (!this.posicion.dentroDelRango(victima.getPosicion(), this.getDistanciaDeAtaque())){
			throw new FueraDeRangoException();
		}
		
		if (this.equipo.existePersonaje(victima.getNombre())){
			throw new IntentandoAtacarAUnCompanieroException();
		}
		if(this.equipo.getAtaquesRestantes() == 0){
			throw new NoTienesAtaquesRestantesException();
			
		}
		if (victima.getPorcentajeSalud() == 0){
			throw new PersonajeInexistenteException();
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
		this.ataqueEspecial.ReproducirAtaque();
				
	}

	public void recibirDanio(int danioARecibir, int poderDePeleaEnemigo){
		if (poderDePeleaEnemigo < this.getPoderDePelea()){
			danioARecibir = (int)(danioARecibir - (danioARecibir * (REDUCCION_DE_ATAQUE / 100.0f)));
		}
		this.salud.disminuir(danioARecibir);
		
		if (this.salud.esCero()){
			this.equipo.eliminar(this);
		}
	}
	
	public void reducirSalud(int cantidad)
	{
		this.salud.disminuir(cantidad);
	}
	
	public void reestablecer(){
		/*deja todo listo para el siguiente turno*/
		this.estadoTransformacionActual.actualizarEstado(this);
		this.aumentarKi(KI_POR_TURNO);
	}	
	
	private void actualizarMovimientosRestantes(int velocidadAnterior){
		equipo.actualizarMovimientosRestantes(this, velocidadAnterior, this.getVelocidad());
		
	}
	
	public EstadoActividad getEstado() {
		return this.estadoTransformacionActual;
	}

	public void regenerarSalud(int plusVida) {
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
	
	//se puede hacer definiendo el equals en cada estado de actividad
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
		caracteristicas.put("Velocidad", this.getVelocidad());
		caracteristicas.put("DistanciaDeAtaque", this.getDistanciaDeAtaque());
		caracteristicas.put("PoderDePelea", this.getPoderDePelea());
		return caracteristicas;
	}

	public Hashtable<String, Integer> darCaracteriticasTransormacion() {
		Hashtable<String, Integer> caracteristicas = new Hashtable<String, Integer>();
		//caracteristicas.put("Ki", estadoTransformacionActual.getEstadoSiguiente().); ki necesario
		caracteristicas.put("Velocidad", estadoTransformacionActual.getEstadoSiguiente().getVelocidad());
		caracteristicas.put("DistanciaDeAtaque", estadoTransformacionActual.getEstadoSiguiente().getDistanciaDeAtaque());
		caracteristicas.put("PoderDePelea", estadoTransformacionActual.getEstadoSiguiente().getPoderDePelea());
		return caracteristicas;
		
	}
}
