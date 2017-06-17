package personajes.elementos;

import personajes.Personaje;
import tablero.Posicion;

public interface EstadoActividad
{
	public abstract void aplicarKi(Personaje personaje, int cantidad);
	public abstract void aplicarMovimiento(Personaje personaje, Posicion nuevaPosicion);
	public abstract void reducirTurnos();
	public abstract void setSiguienteEstado(EstadoActividad estadoTransformacionActual, int i);
	public abstract int getVelocidad();
	public abstract int getPoderDePelea();
	public abstract int getDistanciaDeAtaque();
	public abstract void transformar(Personaje personaje);
	public abstract void realizarAtaqueBasico(Personaje victima);
	public abstract void realizarAtaqueEspecial(Personaje victima, int porcentaje);
	public abstract String getNombre();
	public abstract void realizarAtaqueEspecial(Personaje atacante, Personaje victima);
}
