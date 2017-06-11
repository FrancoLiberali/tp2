package funcionamientoPersonaje;

public class Salud 
{
	private int saludInicial;
	private int saludActual;
	
	public Salud(int salud)
	{
		this.saludActual = salud;
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
		return (this.saludActual/this.saludInicial) * 100;
	}
	
	public void aumentar(int salud)
	{
		int nuevaSalud = salud + this.saludActual;
		if(nuevaSalud > this.saludInicial){
			nuevaSalud = this.saludInicial;
		}
		
		this.saludActual = nuevaSalud;
	}
	
	public void disminuir(int poderPelea)
	{
		int nuevaSalud = this.saludActual - poderPelea;
		if(nuevaSalud <= 0){
			nuevaSalud = 0;
		}
		
		this.saludActual = nuevaSalud;
	}


}
