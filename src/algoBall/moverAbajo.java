package algoBall;

import funcionamientoTablero.Posicion;

public class moverAbajo extends Movimiento {

protected Posicion darPosicionNueva (Posicion posicion) {
		
		Posicion posicionNueva = posicion.darAbajo();
		return posicionNueva;
	}

}