package algoBall;

import exceptions.YaNoPuedeAtacarException;
import funcionamientoPersonaje.EstadoTransformacion;
import funcionamientoPersonaje.Personaje;
import funcionamientoTablero.Posicion;
import funcionamientoTablero.Tablero;

public class AlgoBall {
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
		
	public void finalizarTurno(){
		turnoActual.reestablecer();
		turnoActual = turnoActual.getTurnoSiguiente();
	}
	
	public void moverIzquierda(String nombrePersonaje){
		this.turnoActual.moverIzquierda(nombrePersonaje);
	}
	public void moverAbajo(String nombrePersonaje){
		this.turnoActual.moverAbajo(nombrePersonaje);
	}
	public void moverDerecha(String nombrePersonaje){
		this.turnoActual.moverDerecha(nombrePersonaje);
	}
	public void moverArriba(String nombrePersonaje){
		this.turnoActual.moverArriba(nombrePersonaje);
	}
	
	public void realizarAtaqueBasico(String nombrePersonaje, int fila, int columna){
		Posicion posicionVictima = new Posicion (fila,columna,tablero);
		try{
			this.turnoActual.realizarAtaqueBasico(nombrePersonaje, posicionVictima);
		}
		catch(YaNoPuedeAtacarException error){
			/*mensaje al usuario*/
		}
	}
	
	private Personaje crearGoku()
	{
		EstadoTransformacion normalDeGoku= new EstadoTransformacion ("Normal",20,2,2);
		EstadoTransformacion kaioKenDeGoku= new EstadoTransformacion ("Kaio-Ken",40,4,3);
		EstadoTransformacion superSayajinDeGoku= new EstadoTransformacion ("Super Sayajin",60,4,5);
		normalDeGoku.setSiguienteEstado(kaioKenDeGoku,20);
		kaioKenDeGoku.setSiguienteEstado(superSayajinDeGoku,50);
		return (new Personaje("Goku",normalDeGoku));
	}
	
	private Personaje crearMajinBoo()
	{

		EstadoTransformacion normalDeMajinBoo= new EstadoTransformacion ("Normal",30,2,2);
		EstadoTransformacion booMaloDeMajinBoo= new EstadoTransformacion ("Boo Malo",50,2,3);
		EstadoTransformacion booOriginalDeMajinBoo= new EstadoTransformacion ("Boo Original",60,3,4);
		normalDeMajinBoo.setSiguienteEstado(booMaloDeMajinBoo,20);
		booMaloDeMajinBoo.setSiguienteEstado(booOriginalDeMajinBoo,50);
		return (new Personaje("Majin Boo",normalDeMajinBoo));
	}
	
	//private Personaje crearGohan() 
	//{
	//	EstadoTransformacion normalDeGohan = new EstadoTransformacion ("Normal",15,2,2);
	//	EstadoTransformacion superSayjinFase1 = new EstadoTransformacion ("Super Sayajin Fase 1",30,2,2);
	//	EstadoTransformacion superSayajinFase2 = new EstadoTransformacion ("Super Sayajin Fase 2",100,4,3);
	//	
	//	normalDeGohan.setSiguienteEstado(superSayjinFase1, 10);
		
	
	//}
	
	public void iniciarPersonajes(Jugador jugador1, Jugador jugador2)
	{
		
		Personaje personaje1 = this.crearGoku();
		//Personaje personaje2 = this.crearGohan();
		Personaje personaje6 = this.crearMajinBoo();
		
		
		jugador1.agregarPersonaje(personaje1);
		/*jugador1.agregarPersonaje(personaje2);
		jugador1.agregarPersonaje(personaje3);
		jugador2.agregarPersonaje(personaje4);
		jugador2.agregarPersonaje(personaje5);*/
		jugador2.agregarPersonaje(personaje6);
		
		Posicion posicionInicial1 = new Posicion(1,1,tablero);
		/*Posicion posicionInicial2 = new Posicion(1,2,tablero);
		Posicion posicionInicial3 = new Posicion(1,3,tablero);
		Posicion posicionInicial4 = new Posicion(3,1,tablero);
		Posicion posicionInicial5 = new Posicion(3,2,tablero);*/
		Posicion posicionInicial6 = new Posicion(3,3,tablero);
		
		tablero.agregarPersonaje(personaje1, posicionInicial1);
		/*tablero.agregarPersonaje(personaje2, posicionInicial2);
		tablero.agregarPersonaje(personaje3, posicionInicial3);
		tablero.agregarPersonaje(personaje4, posicionInicial4);
		tablero.agregarPersonaje(personaje5, posicionInicial5);*/
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