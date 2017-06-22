package model.personajes.elementos;

public class Salud 
{
	private int saludInicial;
	private int saludActual;
	
	public Salud(int salud)
	{
		this.saludInicial = salud;
		this.saludActual = salud;
	}
	
	public int getSaludInicial()
	{
		return this.saludInicial;
	}
	
	public int getSalud()
	{
		return this.saludActual;
	}
	
	public void setSalud(int nuevaSalud)
	{
		this.saludInicial = nuevaSalud;
	}
	
	public boolean esCero()
	{
		return this.saludActual == 0;
	}
	
	public int getPorcentajeSalud()
	{
		return (this.saludActual * 100) / this.saludInicial;
	}
	
	public void aumentar(Salud saludAAumentar)
	{
		int nuevaSalud = saludAAumentar.getSalud() + this.saludActual;
		if(nuevaSalud > this.saludInicial){
			nuevaSalud = this.saludInicial;
		}
		
		this.saludActual = nuevaSalud;
	}
	
	public void disminuir(Salud saludADisminuir)
	{
		int nuevaSalud = this.saludActual - saludADisminuir.getSalud();
		if(nuevaSalud <= 0){
			nuevaSalud = 0;
		}
		
		this.saludActual = nuevaSalud;
	}


}
