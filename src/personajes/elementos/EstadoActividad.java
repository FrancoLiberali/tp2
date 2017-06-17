package personajes.elementos;

import consumibles.Consumible;
import personajes.Personaje;

public interface EstadoActividad
{
	void aplicarKi(Personaje personaje, int cantidad);
	void actualizarEstado(Personaje personaje);
	void setSiguienteEstado(EstadoActividad estadoTransformacionActual, int i);
	int getVelocidad();
	int getPoderDePelea();
	int getDistanciaDeAtaque();
	EstadoActividad getEstadoSiguiente();
	void transformar(Personaje personaje, Ki ki);
	void realizarAtaqueBasico(Personaje victima);
	void realizarAtaqueEspecial(Personaje victima, int porcentaje);
	String getNombre();
	EstadoActividad getEstadoAnterior();
	void capturarConsumible(Personaje personaje, Consumible consumible);
}
