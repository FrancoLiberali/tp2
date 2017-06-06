package algoBall;


public class AlgoBall {
	private Tablero tablero;
	private Jugador jugador1;
	private Jugador jugador2;
	private Agrupacion agrupacion1;
	private Agrupacion agrupacion2;
	
	public AlgoBall(int dimension, String nombre1, String nombre2)
	{
		this.tablero = new Tablero(dimension);
		this.agrupacion1 = new Agrupacion("enemigosDeLaTierra");
		this.agrupacion2 = new Agrupacion("guerrerosZ");
		this.jugador1 = new Jugador(nombre1, agrupacion1);
		this.jugador2 = new Jugador(nombre2, agrupacion2);
		iniciarPersonajes();
	}
	
	//Lo agregue aca y no en el constructor por si despu�s lo cambiamos
	public void iniciarPersonajes()
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
		
		this.agrupacion1.agregarPersonaje(personaje1);
		this.agrupacion1.agregarPersonaje(personaje2);
		this.agrupacion1.agregarPersonaje(personaje3);
		this.agrupacion2.agregarPersonaje(personaje4);
		this.agrupacion2.agregarPersonaje(personaje5);
		this.agrupacion2.agregarPersonaje(personaje6);
		}
	
	public boolean existePersonaje(String nombre)
	{
		Personaje personajeBuscado = new Personaje(nombre);
		if (this.agrupacion1.existePersonaje(personajeBuscado)
				|| this.agrupacion2.existePersonaje(personajeBuscado)){
			return true;
		}
		return false;
	}
	
	public Personaje getPersonajeConNombre(String nombrePersonaje)
	{
		if(!this.existePersonaje(nombrePersonaje)){
			throw new PersonajeInexistente();
		}
		Personaje personajeBuscado = new Personaje(nombrePersonaje);
		Agrupacion agrupacion = this.agrupacionPerteneciente(nombrePersonaje);
		return (agrupacion.getPersonaje(personajeBuscado));
		
	}
	
	public Agrupacion agrupacionPerteneciente(String nombrePersonaje)
	{
		if(!this.existePersonaje(nombrePersonaje)){
			throw new PersonajeInexistente();
		}
		Personaje personajeBuscado = new Personaje(nombrePersonaje);
		Agrupacion agrupacionBuscada;
		if (this.agrupacion1.existePersonaje(personajeBuscado)){
			agrupacionBuscada = this.agrupacion1;
		}
		
		else{
			agrupacionBuscada = this.agrupacion2;
		}
		
		return agrupacionBuscada;
		}
	
	public void movimientoUnitario(String nombrePersonaje, int x, int y)
	{
		if (x>1 || y>1){
			throw new MovimientoUnitarioInvalido();
		}
		if(!this.existePersonaje(nombrePersonaje)){
			throw new PersonajeInexistente();
		}
		Personaje personajeAMover = this.getPersonajeConNombre(nombrePersonaje);
		this.tablero.movimientoUnitario(personajeAMover, x, y);
	}
	
	public Posicion getPosicionPersonaje(String nombrePersonaje){
		if(!this.existePersonaje(nombrePersonaje)){
			throw new PersonajeInexistente();
		}
		Personaje personajeBuscado = this.getPersonajeConNombre(nombrePersonaje);
		return personajeBuscado.getPosicion();
	}
}