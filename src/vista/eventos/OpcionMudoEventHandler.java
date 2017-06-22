package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vistas.Reproductor;

public class OpcionMudoEventHandler implements EventHandler<ActionEvent> {
	
	 Reproductor reproductor;
	 
	 
	 public OpcionMudoEventHandler(Reproductor reproductor) {
	        this.reproductor = reproductor;
	    }

	    @Override
	    public void handle(ActionEvent actionEvent) {
	        if (!reproductor.estaMudo()) {
	            reproductor.muteOn(); 
	        }
	        else{
	        	reproductor.muteOff();
	        }
	    }

}
