package model.personajes.goku;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_GOKU_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.KI_SEGUNDA_TRANF_GOKU;
import static model.algoBall.ConstantesDelJuego.NOMBRE_GOKU_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.PODER_GOKU_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_GOKU_PRIMERA_TRANSF;

import model.personajes.Personaje;
import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoGokuKaioKen extends EstadoTransformacion {


	public EstadoGokuKaioKen()
	{
		this.nombre = NOMBRE_GOKU_PRIMERA_TRANSF;
		this.velocidad = VELOCIDAD_GOKU_PRIMERA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_GOKU_PRIMERA_TRANSF;
		this.poderDePelea = new Danio(PODER_GOKU_PRIMERA_TRANSF);
		this.siguienteEstado = new EstadoGokuSuperSayajin();
		this.kiParaTransformacion = new Ki(KI_SEGUNDA_TRANF_GOKU);
		this.rutaImagen = "file:src/vista/imagenes/kioken.png";
	}
	
	@Override
	public void actualizarEstado(Personaje goku)
	{
		if(goku.getPorcentajeSalud() < PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU){
			goku.setEstado(new EstadoGokuBuffDanio(goku.getEstado()));
		}
	}
}
