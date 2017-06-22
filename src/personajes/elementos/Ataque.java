package personajes.elementos;

public class Ataque{
	private int poderDePelea;
	private int danio;

	public Ataque(int poderDePelea, int danio){
		this.poderDePelea = poderDePelea;
		this.danio = danio;
	}
	public int getPoderDePelea() {
		return poderDePelea;
	}

	public void setPoderDePelea(int poderDePelea) {
		this.poderDePelea = poderDePelea;
	}

	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}	
}
