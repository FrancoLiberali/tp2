package funcionamientoPersonaje;

import algoBall.Agrupacion;
import algoBall.ConstantesDelJuego;
import exceptions.CasilleroOcupadoException;
import exceptions.FueraDeRangoException;
import exceptions.FueraDelTableroException;
import exceptions.IntentandoAtacarAUnCompanieroException;
import exceptions.KiInsuficienteException;
import exceptions.NoQuedanMovimientosException;
import exceptions.YaNoPuedeEvolucionarException;
import funcionamientoTablero.Posicion;

public abstract class Personaje 
{
	protected Posicion posicion;
	protected String nombre;
	protected int movimientosRestantes;
	protected Ki ki;
	protected Salud salud;
	protected Estado estadoActividad;
	protected EstadoTransformacion estadoTransformacionActual;
	protected Agrupacion agrupacion;
	protected AtaqueEspecial ataqueEspecial;
	
		
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
			int velocidadAnterior = this.getVelocidad();
			this.estadoTransformacionActual = this.estadoTransformacionActual.transformar(this.ki);
			this.actualizarMovimientosRestantes(velocidadAnterior);
		}
		catch (YaNoPuedeEvolucionarException error){
			/*cancela evolucion (mas adelante agregar mensaje a usuario)*/
		}
		catch (KiInsuficienteException error){
			/*cancela evolucion (mas adelante agregar mensaje a usuario)*/
		}
	}
	
	private void actualizarMovimientosRestantes(int velocidadAnterior){
		if (movimientosRestantes == 0){
			return;
		}
		else{
			int movimientosRealizados = velocidadAnterior - movimientosRestantes;
			movimientosRestantes = (this.getVelocidad() - movimientosRealizados);
		}
		
	}
	
	public EstadoTransformacion getEstadoTransformacion(){
		return estadoTransformacionActual;
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
		return this.salud.getSalud();
	}

	public void atacar(Posicion posicionVictima, int danio, int poderDePelea){
		if (!this.posicion.dentroDelRango(posicionVictima, this.getDistanciaDeAtaque())){
			throw new FueraDeRangoException();
		}
		
		Personaje personajeAAtacar = posicionVictima.getPersonaje();
		if (this.agrupacion.existePersonaje(personajeAAtacar.getNombre())){
			throw new IntentandoAtacarAUnCompanieroException();
		}
		personajeAAtacar.recibirDanio(danio, poderDePelea);
		
	}
	
	public void realizarAtaqueBasico(Posicion posicionVictima){
		int poderDePelea =  this.estadoTransformacionActual.getPoderDePelea();
		this.atacar(posicionVictima, poderDePelea, poderDePelea);
		//POR AHORA PORQUE NO HAY CONSUMIBLES ENTONCES ATAQUE BASICO SIEMPRE ES IGUAL A PODER DE PELEA
	}
	
	public int realizarAtaqueEspecial(Posicion posicionVictima){
		int poderDePelea = this.estadoTransformacionActual.getPoderDePelea();
		int ataqueEspecial = this.ataqueEspecial.getAtaque(poderDePelea, this.ki);
		this.atacar(posicionVictima, ataqueEspecial, poderDePelea);
		return ataqueEspecial;
	}
	
	public void setAtaqueEspecial(AtaqueEspecial ataqueEspecial){
		this.ataqueEspecial = ataqueEspecial;
	}

	public void recibirDanio(int danioARecibir, int poderDePeleaEnemigo){
		if (poderDePeleaEnemigo < this.getPoderDePelea()){
			danioARecibir = danioARecibir - (danioARecibir * ConstantesDelJuego.REDUCCION_DE_ATAQUE / 100);
		}
		this.salud.disminuir(danioARecibir);
		if (this.salud.esCero()){
			this.agrupacion.eliminar(this);
		}
	}
		
	public void setAgrupacion(Agrupacion agrupacion){
		this.agrupacion = agrupacion;
	}
	
	public void reestablecer(){
		/*deja todo listo para el siguiente turno*/
		movimientosRestantes = this.getVelocidad();
		ki.sumar(ConstantesDelJuego.KI_POR_TURNO);
	}
	
	public void prohibirMovimientos(){
		movimientosRestantes = 0;
	}
	
	abstract EstadoTransformacion setEstadoNormal();
	
	abstract EstadoTransformacion setPrimerEstadoTransformacion();
	
	abstract EstadoTransformacion setSegundoEstadoTransformacion();

}
