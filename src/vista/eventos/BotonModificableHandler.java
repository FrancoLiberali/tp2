package vista.eventos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.personajes.Personaje;

public abstract class BotonModificableHandler implements EventHandler<ActionEvent> {

    protected Personaje personajeModificador;
    
    public void setPersonaje(Personaje personaje){
    	this.personajeModificador = personaje;
    }
}