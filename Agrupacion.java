package algo3;

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
	
	public Personaje getPersonaje(Personaje personajeBuscado)
	{
		if(!this.existePersonaje(personajeBuscado))
		{
			throw new PersonajeInexistente();
		}
		int i = 0;
		while(i <= this.pertenecientes.size())
		{
			if (this.pertenecientes.get(i).getNombre() == personajeBuscado.getNombre()){
				personajeBuscado = this.pertenecientes.get(i);
			}
		}
		return personajeBuscado;
	}
	
	public boolean existePersonaje(Personaje personajeBuscado) 
	{
		int i = 0;
		while(i <= this.pertenecientes.size())
		{
			if (this.pertenecientes.get(i).getNombre() == personajeBuscado.getNombre()){
				return true;
			}
		}
		return false;
	}

}
