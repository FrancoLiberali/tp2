package algo3;

public class Personaje 
{
	private Posicion posicion;
	private int velocidad;
	private String nombre;
	
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
	}
	
	public int getVelocidad()
	{
		return this.velocidad;
	}
}
