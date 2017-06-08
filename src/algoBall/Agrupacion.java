package algoBall;

import java.util.ArrayList;

public class Agrupacion 
{	
	private String nombre;
	private ArrayList<Personaje> pertenecientes = new ArrayList<Personaje>();
	
	public Agrupacion(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void agregarPersonaje(Personaje psje)
	{
		pertenecientes.add(psje);
	}
	
	public boolean perteneceMismaAgrupacion(Personaje psje)
	{
		return this.pertenecientes.contains(psje);
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public Personaje getPersonaje(String personajeBuscado)
	{
		Personaje personajeEncontrado = null;
		if(!this.existePersonaje(personajeBuscado))
		{
			throw new PersonajeInexistenteException();
		}
		int i = 0;
		while(i <= this.pertenecientes.size())
		{
			if (this.pertenecientes.get(i).getNombre() == personajeBuscado){
				personajeEncontrado = this.pertenecientes.get(i);
			}
		}
		return personajeEncontrado;
	}
	
	public boolean existePersonaje(String personajeBuscado) 
	{
		int i = 0;
		while(i <= this.pertenecientes.size())
		{
			if (this.pertenecientes.get(i).getNombre() == personajeBuscado){
				return true;
			}
		}
		return false;
	}
	
	public void moverIzquierda(String nombrePersonaje){
		Personaje personaje = this.getPersonaje(nombrePersonaje);
		personaje.moverIzquierda();
	}
	public void moverAbajo(String nombrePersonaje){
		Personaje personaje = this.getPersonaje(nombrePersonaje);
		personaje.moverAbajo();
	}
	public void moverDerecha(String nombrePersonaje){
		Personaje personaje = this.getPersonaje(nombrePersonaje);
		personaje.moverDerecha();
	}
	public void moverArriba(String nombrePersonaje){
		Personaje personaje = this.getPersonaje(nombrePersonaje);
		personaje.moverArriba();
	}
}
