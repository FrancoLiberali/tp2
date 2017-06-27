package model.personajes.elementos;

import model.consumibles.Consumible;
import model.personajes.Personaje;

public interface EstadoActividad
{
	void aplicarKi(Personaje personaje, Ki cantidad);
	void actualizarEstado(Personaje personaje);
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
	String getImagen();
	boolean esTemporal();
	Ki getCostoTransformar();
	int getDanioAtaqueEspecial(int porcentaje);
}
