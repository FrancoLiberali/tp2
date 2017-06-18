package tablero;

import algoBall.Posicionable;

public class Casillero {

	private EstadoCasillero estado;
	
	
	public Casillero()
	{
		this.estado = new EstadoVacio();
	}
	
	public boolean estaVacio()
	{
		return (this.estado.estaVacio());
	}
	
	public void ocupar(Posicionable personaje)
	{
		this.estado = this.estado.ocupar();
		this.estado.aplicarConsumible(personaje);
	}
	
	public void vaciar()
	{
		this.estado = this.estado.vaciar();
	}
	
	public void agregarConsumible(Posicionable consumible){
		this.estado.agregarConsumible(consumible);
	}
}
