package controladores.eventos;

import java.util.Hashtable;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import model.algoBall.AlgoBall;
import model.algoBall.JuegoTerminado;
import model.algoBall.Jugador;
import model.exceptions.FueraDeRangoException;
import model.exceptions.NoTienesAtaquesRestantesException;
import model.exceptions.PersonajeEnEstadoChocolate;
import model.exceptions.PersonajeInexistenteException;
import model.personajes.Personaje;
import vistas.CajaDeInformacionPersonaje;
import vistas.Consola;



public class BotonAtaqueBasicoHandler extends BotonAtaqueHandler{
	
	public BotonAtaqueBasicoHandler(AlgoBall juego, Personaje personaje, Hashtable<String,CajaDeInformacionPersonaje> cajas, Consola consola){
		super(juego, personaje, cajas, consola);
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
        try{
        	this.personajeModificador.realizarAtaqueBasico(personajeAAtacar);
        	
        	cajas.get(personajeAAtacar.getNombre()).actualizar();
        	consola.reiniciar();
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