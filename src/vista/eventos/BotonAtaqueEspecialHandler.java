package vista.eventos;

import personajes.Personaje;
import vistas.BarrasDeVida;
import vistas.Consola;

import java.util.Optional;

import algoBall.AlgoBall;
import algoBall.JuegoTerminado;
import algoBall.Jugador;
import exceptions.FueraDeRangoException;
import exceptions.KiInsuficienteException;
import exceptions.NoTienesAtaquesRestantesException;
import exceptions.PersonajeEnEstadoChocolate;
import exceptions.PersonajeInexistenteException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class BotonAtaqueEspecialHandler extends BotonModificableHandler{
	
	private Personaje personajeAAtacar;
	private BarrasDeVida barras;
	private Consola consola;
	private AlgoBall juego;
	
	public BotonAtaqueEspecialHandler(AlgoBall juego, Personaje personaje, BarrasDeVida barras, Consola consola){
		personajeAAtacar = personaje;	
		this.barras = barras;
		this.consola = consola;
		this.juego = juego;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
        try{
        	this.personajeModificador.realizarAtaqueEspecial(personajeAAtacar);
        	barras.actualizar();
        }
        catch(NoTienesAtaquesRestantesException error){
        	this.consola.agregarInformacion("Ya no tienes ataques!");
        }
		catch( KiInsuficienteException error){
			this.consola.agregarInformacion("Ki insuficiente");
		}
        catch(PersonajeEnEstadoChocolate error){
        	this.consola.agregarInformacion("Estas convertido en Chocolate :(");
        }
        catch(PersonajeInexistenteException error){
        	this.consola.agregarInformacion("Ese personaje esta muerto x(");
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
