package algoBall;

import funcionamientoTablero.Posicion;

public class moverDerecha extends Movimiento {


	protected Posicion darPosicionNueva (Posicion posicion) {
		
		Posicion posicionNueva = posicion.darDerecha();
		return posicionNueva;
	}

}
