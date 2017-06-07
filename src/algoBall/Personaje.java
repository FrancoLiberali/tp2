package algoBall;

public class Personaje 
{
	private Posicion posicion;
	private int velocidad;
	private String nombre;
	private int movimientosRestantes;
	
	public Personaje(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public Posicion getPosicion()
	{
		return this.posicion;
	}
	
	public void setPosicion(Posicion pos) 
	{
		this.posicion = pos;
		
	}
	public void setVelocidad( int velocidad)
	{
		this.velocidad = velocidad;
		this.movimientosRestantes = velocidad;
	}
	
	public int getVelocidad()
	{
		return this.velocidad;
	}
	
	public void moverIzquierda(){
		Posicion posicion_nueva = this.posicion.darIzquierda();
		this.mover(posicion_nueva);
	}
	public void moverAbajo(){
		Posicion posicion_nueva = this.posicion.darAbajo();
		this.mover(posicion_nueva);
	}
	public void moverDerecha(){
		Posicion posicion_nueva = this.posicion.darDerecha();
		this.mover(posicion_nueva);
	}
	public void moverArriba(){
		Posicion posicion_nueva = this.posicion.darArriba();
		this.mover(posicion_nueva);
	}
	
	public void mover(Posicion nuevaPosicion){
		if (this.movimientosRestantes == 0){
			throw new NoQuedanMovimientos();
		}
			
		try {
			Posicion posicion_anterior = this.posicion;
			nuevaPosicion.ponerEnTablero(this);
			posicion_anterior.vaciarTableroEnPos();
			this.movimientosRestantes = this.movimientosRestantes - 1;
		}
		catch (CasilleroOcupado error){
			/*cancela movimiento (mas adelante agregar mensaje a usuario)*/
		}
		catch (FueraDelTablero error){
			/*cancela movimiento (mas adelante agregar mensaje a usuario)*/
		}
	}
}
