package personajes;

import static algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_MAJIN_BOO;
import static algoBall.ConstantesDelJuego.KI_INICIAL;
import static algoBall.ConstantesDelJuego.MAJIN_BOO_NOMBRE;
import static algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_MAJIN_BOO;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_MAJIN_BOO;

import personajes.elementos.AtaqueEspecial;
import personajes.elementos.Ki;
import personajes.elementos.Salud;
import personajes.majinBoo.EstadoMajinBooNormal;

public class MajinBoo extends Personaje 
{	
	
	public MajinBoo()
	{
		this.nombre = MAJIN_BOO_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_MAJIN_BOO);
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_MAJIN_BOO, KI_ATQ_ESPECIAL_MAJIN_BOO);
		this.estadoTransformacionActual = new EstadoMajinBooNormal();
		this.rutaImagen = "file:src/vista/imagenes/majinboo.png";
	}
	
	
	@Override
	public void realizarAtaqueEspecial(Personaje victima)
	{	
		this.equipo.restarAtaqueRestates();
		victima.convertirAChocolate();
		this.ki.restar(new Ki(KI_ATQ_ESPECIAL_MAJIN_BOO));
	}
}