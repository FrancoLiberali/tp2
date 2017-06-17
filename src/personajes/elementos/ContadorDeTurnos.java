package personajes.elementos;

import exceptions.SeAcabaronTurnosDelEstadoException;

public class ContadorDeTurnos 
{
	public int turnosIniciales;
	public int turnosRestantes;
	
	public ContadorDeTurnos(int cantTrunos)
	{
		this.setTurnosIniciales(cantTrunos);
		this.setTurnosRestantes(cantTrunos);
	}
	
	public void setTurnosRestantes(int restantes)
	{
		this.turnosRestantes = restantes;
	}
	
	public void setTurnosIniciales(int iniciales)
	{
		this.turnosIniciales = iniciales;
	}
	
	public int getTurnosRestantes()
	{
		return this.turnosRestantes;
	}
	
	public int getTrunosRealizados()
	{
		return this.turnosIniciales - this.turnosRestantes;
	}
	
	public boolean estaEnCero()
	{
		return this.turnosRestantes == 0;
	}
	
	public void reducir()
	{
		this.turnosRestantes--;
		if (this.estaEnCero()){
			throw new SeAcabaronTurnosDelEstadoException();
		}
	}
	
	public void reestablecer()
	{
		this.turnosRestantes = this.turnosIniciales;
	}
}
