package vista.eventos;
import personajes.Personaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public abstract class BotonModificableHandler implements EventHandler<ActionEvent> {

    protected Personaje personajeModificador;
    
    public void setPersonaje(Personaje personaje){
    	this.personajeModificador = personaje;
    }
}