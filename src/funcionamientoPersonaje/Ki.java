package funcionamientoPersonaje;

import exceptions.KiInsuficienteException;

public class Ki implements Comparable <Ki>  
{
	private int ki;
	
	public Ki(int kiInicial)
	{
		this.ki = kiInicial;
	}
	
	public void sumar(int cantidad)
	{
		this.ki = this.ki + cantidad;
	}
	
	public int getKi()
	{
		return this.ki;
	}
	
	public void restar(Ki kiARestar)
	{
		if(this.compareTo(kiARestar) == -1){
			throw new KiInsuficienteException();
		}
		this.ki = this.ki - kiARestar.getKi();
	}
	
	@Override
	public int compareTo(Ki otroKi) 
	{
	  return Integer.compare(this.ki, otroKi.getKi());
	}
}
