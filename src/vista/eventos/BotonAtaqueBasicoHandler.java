package vista.eventos;

import personajes.Personaje;
import vistas.BarrasDeVida;
import vistas.Consola;

import java.io.File;

import exceptions.NoTienesAtaquesRestantesException;
import exceptions.PersonajeEnEstadoChocolate;
import exceptions.PersonajeInexistenteException;
import javafx.event.ActionEvent;
import javafx.scene.media.AudioClip;


public class BotonAtaqueBasicoHandler extends BotonModificableHandler{
	
	private Personaje personajeAAtacar;
	private BarrasDeVida barras;
	private Consola consola;
	
	public BotonAtaqueBasicoHandler(Personaje personaje, BarrasDeVida barras, Consola consola){
		personajeAAtacar = personaje;		
		this.barras = barras;
		this.consola = consola;
		
	}
	
	public void sonidoAtaque(){
		
		String path = "src/vista/musica/burning_fire.wav";
		File archivo = new File(path);
		AudioClip sonidoAtaque = new AudioClip(archivo.toURI().toString());
		sonidoAtaque.play();
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		try{
			this.personajeModificador.realizarAtaqueBasico(personajeAAtacar);
			sonidoAtaque();
			barras.actualizar();
		}
		catch(NoTienesAtaquesRestantesException error){
			consola.agregarInformacion("Ya realiz� un ataque!");
		}
		catch (PersonajeInexistenteException error){
			this.consola.agregarInformacion("El enemigo a muerto");
		}
		catch (PersonajeEnEstadoChocolate error){
	       	this.consola.agregarInformacion("Personaje convertido a chocolate :( ");
	    }
	}
}