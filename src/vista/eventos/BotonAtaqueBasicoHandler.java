package vista.eventos;

import personajes.Personaje;
import vistas.BarrasDeVida;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.scene.media.AudioClip;


public class BotonAtaqueBasicoHandler extends BotonModificableHandler{
	
	private Personaje personajeAAtacar;
	private BarrasDeVida barras;
	public BotonAtaqueBasicoHandler(Personaje personaje, BarrasDeVida barras){
		personajeAAtacar = personaje;		
		this.barras = barras;
	}
	
	public void sonidoAtaque(){
		
		String path = "src/vista/musica/burning_fire.wav";
		File archivo = new File(path);
		AudioClip sonidoAtaque = new AudioClip(archivo.toURI().toString());
		sonidoAtaque.play();
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
        this.personajeModificador.realizarAtaqueBasico(personajeAAtacar);
        sonidoAtaque();
        barras.actualizar();
    }
}
