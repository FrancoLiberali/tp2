package tablero;

import algoBall.Posicionable;

public class Casillero {

	private Posicionable contenido;
	private EstadoCasillero estado;
	
	
	public Casillero()
	{
		this.estado = new EstadoVacio();
	}
	
	public boolean estaVacio()
	{
		return (this.estado.estaVacio());
	}
	
	public void ocupar()
	{
		this.estado = this.estado.ocupar();
	}
	
	public void vaciar()
	{
		this.estado = this.estado.vaciar();
	}

	public Posicionable getContenido()
	{
		return this.contenido;
	}
}
