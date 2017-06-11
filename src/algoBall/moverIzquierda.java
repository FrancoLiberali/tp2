package algoBall;

import funcionamientoTablero.Posicion;

public class moverIzquierda extends Movimiento {

protected Posicion darPosicionNueva (Posicion posicion) {
		
		Posicion posicionNueva = posicion.darIzquierda();
		return posicionNueva;
	}

}