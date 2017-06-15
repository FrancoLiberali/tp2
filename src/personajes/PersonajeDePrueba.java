package funcionamientoPersonaje.personajes;

import funcionamientoPersonaje.elementos.EstadoTransformacion;

public class PersonajeDePrueba extends Personaje {
	
	public PersonajeDePrueba()
	{
		this.nombre = "estadoDePrueba";
		this.estadoTransformacionActual = setEstadoNormal();
		this.movimientosRestantes = estadoTransformacionActual.getVelocidad();
	}

	public EstadoTransformacion setEstadoNormal() {
		String nombre = "estadoDePrueba";
		int velocidad = 100;
		int distAtac = 11;
		int poderDePelea = 11;

		EstadoTransformacion estadoDePrueba = new EstadoTransformacion(nombre, poderDePelea, distAtac, velocidad);
		return estadoDePrueba;
	}

	@Override
	EstadoTransformacion setPrimerEstadoTransformacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	EstadoTransformacion setSegundoEstadoTransformacion() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
