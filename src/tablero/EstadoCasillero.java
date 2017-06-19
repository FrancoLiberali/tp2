package tablero;

import algoBall.Posicionable;

public interface EstadoCasillero {
	boolean estaVacio();
	EstadoCasillero ocupar();	
	EstadoCasillero vaciar();
	void agregarConsumible(Posicionable consumible);
	void aplicarConsumible(Posicionable personaje);
	Posicionable getConsumible();
}
