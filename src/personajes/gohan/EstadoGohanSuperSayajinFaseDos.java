package personajes.gohan;

import static algoBall.ConstantesDelJuego.DISTANCIA_GOHAN_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_GOHAN_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_GOHAN_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_GOHAN_SEGUNDA_TRANSF;

import exceptions.YaNoPuedeEvolucionarException;
import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;
import personajes.elementos.Ki;

public class EstadoGohanSuperSayajinFaseDos extends EstadoTransformacion  {
	
	public EstadoGohanSuperSayajinFaseDos()
	{
		this.nombre = NOMBRE_GOHAN_SEGUNDA_TRANSF;
		this.velocidad = VELOCIDAD_GOHAN_SEGUNDA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_GOHAN_SEGUNDA_TRANSF;
		this.poderDePelea = PODER_GOHAN_SEGUNDA_TRANSF;
		this.siguienteEstado = null;
		this.rutaImagen = "file:src/vista/imagenes/gohanSuperSaiyan2.png";
	}
	
	@Override
	public void transformar(Personaje personaje, Ki kiPersonaje) {
		throw new YaNoPuedeEvolucionarException();
	}
}
