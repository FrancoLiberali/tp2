package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import vistas.Reproductor;

public class OpcionMudoEventHandler implements EventHandler<ActionEvent> {
	
	 Reproductor reproductor;
	 MenuItem opcionMudo;
	 
	 
	 public OpcionMudoEventHandler(Reproductor reproductor, MenuItem opcionMudo) {
	        this.reproductor = reproductor;
	        this.opcionMudo = opcionMudo;
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
