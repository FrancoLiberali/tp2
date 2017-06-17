package personajes.elementos;

import consumibles.Consumible;
import personajes.Personaje;
import tablero.Posicion;

public interface EstadoActividad
{
	void aplicarKi(Personaje personaje, int cantidad);
	void aplicarMovimiento(Personaje personaje, Posicion nuevaPosicion);
	void actualizarEstado(Personaje personaje);
	void setSiguienteEstado(EstadoActividad estadoTransformacionActual, int i);
	int getVelocidad();
	int getPoderDePelea();
	int getDistanciaDeAtaque();
	EstadoActividad getEstadoSiguiente();
	void transformar(Personaje personaje);
	void realizarAtaqueBasico(Personaje victima);
	void realizarAtaqueEspecial(Personaje victima, int porcentaje);
	String getNombre();
	void realizarAtaqueEspecial(Personaje atacante, Personaje victima);
	EstadoActividad getEstadoAnterior();
	void capturarConsumible(Personaje personaje, Consumible consumible);
	void reducirKi(Personaje personaje, int cantidad);
}
