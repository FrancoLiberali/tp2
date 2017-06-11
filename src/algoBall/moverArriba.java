package algoBall;

import funcionamientoTablero.Posicion;

public class moverArriba extends Movimiento {


protected Posicion darPosicionNueva (Posicion posicion) {
	
	Posicion posicionNueva = posicion.darArriba();
	return posicionNueva;
}

}
