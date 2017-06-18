package tablero;

public interface EstadoCasillero {
	boolean estaVacio();
	EstadoCasillero ocupar();	
	EstadoCasillero vaciar();
}
