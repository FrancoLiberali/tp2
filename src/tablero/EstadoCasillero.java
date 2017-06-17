package tablero;

public interface EstadoCasillero {
	public boolean estaVacio();
	
	public EstadoCasillero ocupar();
	
	public EstadoCasillero vaciar();
}
