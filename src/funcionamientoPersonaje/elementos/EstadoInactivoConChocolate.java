package funcionamientoPersonaje.elementos;

import exceptions.PersonajeInactivoNoPuedeAtacarException;
import funcionamientoPersonaje.personajes.Personaje;
import funcionamientoTablero.Posicion;

import static algoBall.ConstantesDelJuego.TURNOS_ESTUNEO_MAJIN_BOO;

public class EstadoInactivoConChocolate implements EstadoActividad 
{
	
	private ContadorDeTurnos cantTurnos = new ContadorDeTurnos(TURNOS_ESTUNEO_MAJIN_BOO);
	private EstadoActividad siguienteEstado;

	
	public void aplicarKi(Personaje personaje, int cantidad) 
	{}

	public void aplicarMovimiento(Personaje personaje, Posicion nuevaPosicion) {
		/*mensaje al usuario*/
	}

	public int aplicarAtaqueEspecial(Personaje personaje, Posicion posicionVictima) {
		throw new PersonajeInactivoNoPuedeAtacarException();
		
	}

	public void aplicarAtaqueBasico(Personaje personaje, Posicion posicionVictima) {
		throw new PersonajeInactivoNoPuedeAtacarException();
	}

	
	
	public void reducirTurnos()
	{
		this.cantTurnos.reducir();
	}
	
	public ContadorDeTurnos getContadorDeTurnos()
	{
		return cantTurnos;
	}

	
	
	public void setSiguienteEstado(EstadoActividad estadoTransformacionActual, int i) {
		this.siguienteEstado = estadoTransformacionActual;
	}

	@Override
	public int getVelocidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPoderDePelea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDistanciaDeAtaque() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void realizarAtaqueBasico(Posicion posicionVictima) {
		// error
		
	}

	@Override
	public void realizarAtaqueEspecial(Posicion posicionVictima, int porcentaje) {
		// error
		
	}

	@Override
	public EstadoActividad transformar(Ki ki) {
		return this.siguienteEstado;
	}

	@Override
	public void setVidasAbsorvidasNecesarias(int cellCantAbsorverVidaPrimeraTransf) {
		//error
		
	}

	@Override
	public boolean seAbsorvieronVidasNecesarias(int vidasAbsorvidas) {
		// error
		return false;
	}

	@Override
	public boolean vidaDeCompanierosEsMenorALaNecesariaParaTranformar(int porcentajeVidaPiccolo,
			int porcentajeVidaGoku) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean vidaDeGohanEsMenorALaNecesariaParaTranformar(int porcentajeSalud) {
		// TODO Auto-generated method stub
		return false;
	}


}
