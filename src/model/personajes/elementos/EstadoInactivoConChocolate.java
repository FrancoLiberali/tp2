package model.personajes.elementos;

import static model.algoBall.ConstantesDelJuego.*;

import model.consumibles.Consumible;
import model.exceptions.PersonajeEnEstadoChocolate;
import model.exceptions.PersonajeInactivoNoPuedeAtacarException;
import model.personajes.Personaje;
import model.tablero.Posicion;

public class EstadoInactivoConChocolate implements EstadoActividad 
{
	private EstadoActividad estadoAnterior;
	private EstadoActividad estadoSiguiente;
	private String nombre = CHOCOLATE;
	private ContadorDeTurnos cantTurnos = new ContadorDeTurnos(TURNOS_ESTUNEO_MAJIN_BOO);
	String rutaImagen = "file:src/vista/imagenes/estadoChocolate.png";
	
	public void aplicarKi(Personaje personaje, Ki cantidad) {}

	public int aplicarAtaqueEspecial(Personaje personaje, Posicion posicionVictima) {
		throw new PersonajeInactivoNoPuedeAtacarException();
	}

	public void aplicarAtaqueBasico(Personaje personaje, Posicion posicionVictima) {
		throw new PersonajeInactivoNoPuedeAtacarException();
	}
	
	public ContadorDeTurnos getContadorDeTurnos()
	{
		return cantTurnos;
	}

	public void setEstadoAnterior(EstadoActividad anterior) {
		this.estadoAnterior = anterior;
	}

	@Override
	public int getVelocidad() {
		return this.estadoAnterior.getVelocidad();
	}

	@Override
	public int getPoderDePelea() {
		return this.estadoAnterior.getPoderDePelea();
	}

	@Override
	public int getDistanciaDeAtaque() {
		return this.estadoAnterior.getDistanciaDeAtaque();
	}

	@Override
	public void realizarAtaqueBasico(Personaje victima) {
		throw new PersonajeEnEstadoChocolate();
	}

	@Override
	public void realizarAtaqueEspecial(Personaje victima, int porcentaje) {
		throw new PersonajeEnEstadoChocolate();
	}

	@Override
	public void transformar(Personaje personaje, Ki ki) {
		throw new PersonajeEnEstadoChocolate();
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public void actualizarEstado(Personaje personaje) {
		cantTurnos.reducir();
		if (cantTurnos.estaEnCero()){
			personaje.setEstado(estadoAnterior);
			return;
		}
	}

	@Override
	public void capturarConsumible(Personaje personaje, Consumible consumible) {
		throw new PersonajeEnEstadoChocolate();
	}

	@Override
	public EstadoActividad getEstadoSiguiente(){
		return this.estadoSiguiente;
	}

	@Override
	public EstadoActividad getEstadoAnterior() {
		return this.estadoAnterior;	
	}

	@Override
	public String getImagen() {
		
		return this.rutaImagen;
	}
	
	public boolean esTemporal(){
		return true;
	}



}
