package model.tablero;

import model.algoBall.Posicionable;

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
		this.estado.aplicarConsumible(personaje);
		this.estado = this.estado.ocupar();
		
	}
	
	public void vaciar()
	{
		this.estado = this.estado.vaciar();
	}
	
	public void agregarConsumible(Posicionable consumible){
		this.estado.agregarConsumible(consumible);
	}
	
	public Posicionable getConsumible(){
		return this.estado.getConsumible();
	}
}
