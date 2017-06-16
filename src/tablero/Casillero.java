package tablero;

public class Casillero {

	//private Personaje personaje;
	//private Consumible consumible;
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

}
