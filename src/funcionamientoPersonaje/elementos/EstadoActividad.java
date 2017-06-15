package funcionamientoPersonaje.elementos;

import funcionamientoPersonaje.personajes.Personaje;
import funcionamientoTablero.Posicion;

public interface EstadoActividad
{
	public abstract void aplicarKi(Personaje personaje, int cantidad);
	public abstract void aplicarMovimiento(Personaje personaje, Posicion nuevaPosicion);
	public abstract void reducirTurnos();
	public abstract void setSiguienteEstado(EstadoActividad estadoTransformacionActual, int i);
	public abstract int getVelocidad();
	public abstract int getPoderDePelea();
	public abstract int getDistanciaDeAtaque();
	public abstract EstadoActividad transformar(Ki ki);
	public abstract void realizarAtaqueBasico(Personaje victima);
	public abstract void realizarAtaqueEspecial(Personaje victima, int porcentaje);
	public abstract void setVidasAbsorvidasNecesarias(int cellCantAbsorverVidaPrimeraTransf);
	public abstract boolean seAbsorvieronVidasNecesarias(int vidasAbsorvidas);
	public abstract boolean vidaDeCompanierosEsMenorALaNecesariaParaTranformar(int porcentajeVidaPiccolo,
			int porcentajeVidaGoku);
	public abstract boolean vidaDeGohanEsMenorALaNecesariaParaTranformar(int porcentajeSalud);
	public abstract Object getNombre();
}
