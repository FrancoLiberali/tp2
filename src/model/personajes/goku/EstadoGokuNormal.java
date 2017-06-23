package model.personajes.goku;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_GOKU_NORMAL;
import static model.algoBall.ConstantesDelJuego.KI_GOKU_PRIMERA_TRANF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static model.algoBall.ConstantesDelJuego.PODER_GOKU_NORMAL;
import static model.algoBall.ConstantesDelJuego.PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_GOKU_NORMAL;

import model.personajes.Personaje;
import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoGokuNormal extends EstadoTransformacion {
	
	public EstadoGokuNormal()
	{
		this.nombre = NOMBRE_TRANF_NORMAL;
		this.velocidad = VELOCIDAD_GOKU_NORMAL;
		this.distanciaDeAtaque = DISTANCIA_GOKU_NORMAL;
		this.poderDePelea = new Danio(PODER_GOKU_NORMAL);
		this.siguienteEstado = new EstadoGokuKaioKen();
		this.kiParaTransformacion = new Ki(KI_GOKU_PRIMERA_TRANF);
		this.rutaImagen = "file:src/vistas/imagenes/gokuNormal.png";
	}
		
	@Override
	public void actualizarEstado(Personaje goku)
	{
		if(goku.getPorcentajeSalud() < PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU){
			goku.setEstado(new EstadoGokuBuffDanio(goku.getEstado()));
		}
	}

}
