package algoBall;


public class AlgoBall {
	private Jugador jugadorEnJuego;
	private Turno turnoActual;
	private Tablero tablero;
	
	public AlgoBall(String nombre1, String nombre2)
	{
		this.tablero = new Tablero(8);
		Jugador jugador1 = new Jugador(nombre1, "enemigosDeLaTierra");
		Jugador jugador2 = new Jugador(nombre2, "guerrerosZ");
		iniciarPersonajes(jugador1, jugador2);
		this.turnoActual = iniciarTurnos(jugador1, jugador2);
	}
	
	public Turno iniciarTurnos(Jugador jugador1, Jugador jugador2){
		Turno turnoJugador1 = new Turno(jugador1);
		Turno turnoJugador2 = new Turno(jugador2);
		turnoJugador1.setTurnoSiguiente(turnoJugador2);
		turnoJugador2.setTurnoSiguiente(turnoJugador1);
		return turnoJugador1;
	}
	
	public void elegirJugadorActual(){
		jugadorEnJuego = turnoActual.getJugador();
	}
	
	public void finalizarTurno(){
		turnoActual.restablecer();
		turnoActual = turnoActual.getTurnoSiguiente();
		this.elegirJugadorActual();
	}
	
	public void moverIzquierda(String nombrePersonaje){
		this.jugadorEnJuego.moverIzquierda(nombrePersonaje);
	}
	public void moverAbajo(String nombrePersonaje){
		this.jugadorEnJuego.moverAbajo(nombrePersonaje);
	}
	public void moverDerecha(String nombrePersonaje){
		this.jugadorEnJuego.moverDerecha(nombrePersonaje);
	}
	public void moverArriba(String nombrePersonaje){
		this.jugadorEnJuego.moverArriba(nombrePersonaje);
	}
	
	
	
	//Lo agregue aca y no en el constructor por si despu�s lo cambiamos
	public void iniciarPersonajes(Jugador jugador1, Jugador jugador2)
	{
		Personaje personaje1 = new Personaje("Goku");
		Personaje personaje2 = new Personaje("Gohan");
		Personaje personaje3 = new Personaje("Piccolo");
		Personaje personaje4 = new Personaje("Cell");
		Personaje personaje5 = new Personaje("Freezer");
		Personaje personaje6 = new Personaje("Majin Boo");

		personaje1.setVelocidad(2);
		personaje2.setVelocidad(2);
		personaje3.setVelocidad(2);
		personaje4.setVelocidad(2);
		personaje5.setVelocidad(4);
		personaje6.setVelocidad(2);
		
		jugador1.agregarPersonaje(personaje1);
		jugador1.agregarPersonaje(personaje2);
		jugador1.agregarPersonaje(personaje3);
		jugador2.agregarPersonaje(personaje4);
		jugador2.agregarPersonaje(personaje5);
		jugador2.agregarPersonaje(personaje6);
		
		Posicion posicionInicial1 = new Posicion(1,1,tablero);
		Posicion posicionInicial2 = new Posicion(1,2,tablero);
		Posicion posicionInicial3 = new Posicion(1,3,tablero);
		Posicion posicionInicial4 = new Posicion(3,1,tablero);
		Posicion posicionInicial5 = new Posicion(3,2,tablero);
		Posicion posicionInicial6 = new Posicion(3,3,tablero);
		
		tablero.agregarPersonaje(personaje1, posicionInicial1);
		tablero.agregarPersonaje(personaje2, posicionInicial2);
		tablero.agregarPersonaje(personaje3, posicionInicial3);
		tablero.agregarPersonaje(personaje4, posicionInicial4);
		tablero.agregarPersonaje(personaje5, posicionInicial5);
		tablero.agregarPersonaje(personaje6, posicionInicial6);
		}
	
	/*DE ACA PARA ABAJO ESTA TODO SIN MANTENIMIENTO DE LOS CAMBIOS
	 * public boolean existePersonaje(String nombre)
	{
		if (this.jugador1.existePersonaje(nombre)
				|| this.jugador2.existePersonaje(nombre)){
			return true;
		}
		return false;
	}
	
	public Personaje getPersonajeConNombre(String nombrePersonaje)
	{
		if(!this.existePersonaje(nombrePersonaje)){
			throw new PersonajeInexistente();
		}
		
		Agrupacion agrupacion = this.agrupacionPerteneciente(nombrePersonaje);
		return (agrupacion.getPersonaje(nombrePersonaje));
		
	}
	
	public Agrupacion agrupacionPerteneciente(String nombrePersonaje)
	{
		if(!this.existePersonaje(nombrePersonaje)){
			throw new PersonajeInexistente();
		}
		Agrupacion agrupacionBuscada;
		if (this.jugador1.existePersonaje(nombrePersonaje)){
			agrupacionBuscada = this.jugador1.getAgrupacion();
		}
		
		else{
			agrupacionBuscada = this.jugador1.getAgrupacion();
		}
		
		return agrupacionBuscada;
		}*/
	
	/*public void mover_izquierda(String nombrePersonaje, int x, int y)
	{
		if (x>1 || y>1){
			throw new MovimientoUnitarioInvalido();
		}
		if(!this.existePersonaje(nombrePersonaje)){
			throw new PersonajeInexistente();
		}
		Personaje personajeAMover = this.getPersonajeConNombre(nombrePersonaje);
		this.tablero.movimientoUnitario(personajeAMover, x, y);
	}*/
	
	/*public Posicion getPosicionPersonaje(String nombrePersonaje){
		if(!this.existePersonaje(nombrePersonaje)){
			throw new PersonajeInexistente();
		}
		Personaje personajeBuscado = this.getPersonajeConNombre(nombrePersonaje);
		return personajeBuscado.getPosicion();
	}*/
}