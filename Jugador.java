package algo3;

public class Jugador 
{
	private String nombre;
	private Agrupacion equipo;
	
	public Jugador(String Nombre, Agrupacion equipo)
	{
		this.nombre = Nombre;
		this.equipo = equipo;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public Agrupacion getEquipo()
	{
		return this.equipo;
	}
}
