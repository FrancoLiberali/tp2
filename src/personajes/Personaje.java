package personajes;

import algoBall.ConstantesDelJuego;
import algoBall.Equipo;
import algoBall.Posicionable;
import consumibles.Consumible;
import exceptions.FueraDeRangoException;
import exceptions.IntentandoAtacarAUnCompanieroException;
import exceptions.KiInsuficienteException;
import exceptions.NoTienesAtaquesRestantesException;
import exceptions.YaNoPuedeEvolucionarException;
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
		try{
			int velocidadAnterior = this.getVelocidad();
			this.estadoTransformacionActual.transformar(this);
			this.actualizarMovimientosRestantes(velocidadAnterior);
		}
		catch (YaNoPuedeEvolucionarException error){
			/*cancela evolucion (mas adelante agregar mensaje a usuario)*/
		}
		catch (KiInsuficienteException error){
			/*cancela evolucion (mas adelante agregar mensaje a usuario)*/
		}
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
		
	}
	public void realizarAtaqueBasico(Personaje victima){
		try{
			this.verificarAtaque(victima);
			this.equipo.restarAtaqueRestates();
			this.estadoTransformacionActual.realizarAtaqueBasico(victima);
		}
		catch(NoTienesAtaquesRestantesException error){
		}
	}

	public void realizarAtaqueEspecial(Personaje victima)
	{
		try{
			this.verificarAtaque(victima);
			this.estadoTransformacionActual.realizarAtaqueEspecial(victima,
					this.ataqueEspecial.getPorcentaje(this.ki));
			this.equipo.restarAtaqueRestates();
		}
		catch( KiInsuficienteException error){
		}
				
	}
	

	public void recibirDanio(int danioARecibir, int poderDePeleaEnemigo){
		if (poderDePeleaEnemigo < this.getPoderDePelea()){
			danioARecibir = danioARecibir - (danioARecibir * ConstantesDelJuego.REDUCCION_DE_ATAQUE / 100);
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
		this.aumentarKi(ConstantesDelJuego.KI_POR_TURNO);
	}	
	
	private void actualizarMovimientosRestantes(int velocidadAnterior){
		equipo.actualizarMovimientosRestantes(this, velocidadAnterior, this.getVelocidad());
		
	}

	public void convertirAChocolate(){
        EstadoActividad transformacionAChocolate = new EstadoInactivoConChocolate(); 
        transformacionAChocolate.setSiguienteEstado(this.estadoTransformacionActual, 0);
        this.estadoTransformacionActual = transformacionAChocolate;
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
		return rutaImagen;
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
}
