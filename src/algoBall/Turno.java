package algoBall;

public class Turno {
	private Jugador jugador;
	private int cantidadDeAtaquesRestantes;
	private Turno turnoSiguiente;
	
	public Turno(Jugador jugador){
		this.jugador = jugador;
		this.cantidadDeAtaquesRestantes = 1;
	}
	public Jugador getJugador(){
		return jugador;
	}
	
	public int getCantidadDeAtaquesRestantes(){
		return cantidadDeAtaquesRestantes;
	}
	
	public void restablecer(){
		cantidadDeAtaquesRestantes = 1;
	}
	
	public Turno getTurnoSiguiente(){
		return turnoSiguiente;
	}
	
	public void setTurnoSiguiente(Turno turnoSiguiente){
		this.turnoSiguiente = turnoSiguiente;
	}
}
