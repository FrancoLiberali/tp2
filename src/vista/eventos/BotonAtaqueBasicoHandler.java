package vista.eventos;

import personajes.Personaje;
import vistas.BarrasDeVida;
import vistas.Consola;

import java.io.File;
import java.util.Optional;

import algoBall.AlgoBall;
import algoBall.JuegoTerminado;
import algoBall.Jugador;
import exceptions.FueraDeRangoException;
import exceptions.NoTienesAtaquesRestantesException;
import exceptions.PersonajeEnEstadoChocolate;
import exceptions.PersonajeInexistenteException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;


public class BotonAtaqueBasicoHandler extends BotonModificableHandler{
	
	private Personaje personajeAAtacar;
	private BarrasDeVida barras;
	private Consola consola;
	private AlgoBall juego;
	
	public BotonAtaqueBasicoHandler(AlgoBall juego, Personaje personaje, BarrasDeVida barras, Consola consola){
		personajeAAtacar = personaje;		
		this.barras = barras;
		this.consola = consola;
		this.juego = juego;
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
        	this.consola.agregarInformacion("Ya no tienes ataques!");
        }
        catch(PersonajeInexistenteException error){
        	this.consola.agregarInformacion("Ese personaje esta muerto x(");
        }
        catch(PersonajeEnEstadoChocolate error){
        	this.consola.agregarInformacion("Estas convertido en Chocolate :(");
        }
        catch(FueraDeRangoException error){
        	this.consola.agregarInformacion("No! no puedes atacar mas lejos que tu distancia de ataque");
        }
        catch (JuegoTerminado error){
        	ButtonType salir = new ButtonType("Salir");
        	Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Juego terminado");
            Jugador jugadorGanador = juego.getJugadorActual();
            String mensaje = "El ganador es: "+ jugadorGanador.getNombre() + ", con el equipo: " + jugadorGanador.getEquipo().getNombre();
            alert.setContentText(mensaje);
            alert.getButtonTypes().setAll(salir);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == salir){
            	System.exit(0);
            }
        }
	}
}