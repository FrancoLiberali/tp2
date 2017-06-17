package personajes;

import static algoBall.ConstantesDelJuego.CELL_NOMBRE;
import static algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_CELL;
import static algoBall.ConstantesDelJuego.KI_INICIAL;
import static algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_CELL;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_CELL;

import personajes.cell.EstadoCellNormal;
import personajes.elementos.AtaqueEspecial;
import personajes.elementos.Ki;
import personajes.elementos.Salud;

public class Cell extends Personaje 
{	
	private int vidasAbsorvidas = 0;

	public Cell()
	{
		this.nombre = CELL_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_CELL);
		this.estadoTransformacionActual = new EstadoCellNormal();
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_CELL, KI_ATQ_ESPECIAL_CELL);
		this.rutaImagen = "file:src/vista/imagenes/cell.png";
		
	}

	public int getVidasAbsorvidas() {
		return this.vidasAbsorvidas;
	}
	
	public void absorverVida() {
		this.vidasAbsorvidas++;
	}
	
	@Override
	public void realizarAtaqueEspecial(Personaje victima){
		super.realizarAtaqueEspecial(victima);
		this.absorverVida();
		this.regenerarSalud(this.getPoderDePelea());
		
	}
	


}