package model.personajes.elementos;

import static model.algoBall.ConstantesDelJuego.REDUCCION_DE_ATAQUE;

import model.personajes.Personaje;

public class Danio 
{
	private int danio;
	
	public Danio(int danio)
	{
		this.setDanio(danio);
	}
	
	public int getDanio()
	{
		return this.danio;
	}
	
	public void setDanio(int danio)
	{
		this.danio = danio;
	}
	
	public Danio getDanioContra(Personaje victima)
	{
		return obtenerDanioContra(victima, 0);
	}
	
	public Danio getDanioEspecialContra(Personaje victima, int porcentajeBonus) {
		return obtenerDanioContra(victima, porcentajeBonus);
	}
	
	private Danio obtenerDanioContra(Personaje victima, int plusPorcentaje)
	{
		int danioTotal = this.danio + this.calcularPorcentajeDanio(plusPorcentaje);
		if (this.esMenorAlDe(victima)){
			danioTotal -= this.calcularPorcentajeDanio(REDUCCION_DE_ATAQUE);
		}
		
		return new Danio(danioTotal);
	}
	
	public int obtenerDanioEspecial(int plusPorcentaje)
	{
		return this.danio + this.calcularPorcentajeDanio(plusPorcentaje);
	}
	
	private int calcularPorcentajeDanio(int porcentaje)
	{
		return (int) (this.danio * (porcentaje / 100.0f));
	}
	
	private boolean esMenorAlDe(Personaje personaje)
	{
		return this.danio < personaje.getPoderDePelea();
	}
	
	
}
