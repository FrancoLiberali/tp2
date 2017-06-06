package algo3;

public class Casillero {

	private Personaje personaje;
	
	
	public Casillero()
	{
		this.personaje = null;
	}
	
	public boolean estaVacio()
	{
		return (this.personaje == null);
	}
	
	public void setPersonaje(Personaje psje)
	{
		if(!this.estaVacio()){
			 throw new CasilleroOcupado();
		}
		
		this.personaje = psje;
	}
	
	public void vaciar()
	{
		this.personaje = null;
	}
	
	public Personaje getPersonaje()
	{
		return this.personaje;
	}

}
