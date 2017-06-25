package controladores.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vistas.Reproductor;
import vistas.ReproductorEfectos;

public class OpcionMudoEventHandler implements EventHandler<ActionEvent> {
	
	 Reproductor reproductor;
	 
	 public OpcionMudoEventHandler(Reproductor reproductor) {
	        this.reproductor = reproductor;
	    }

	    @Override
	    public void handle(ActionEvent actionEvent) {
	        if (!reproductor.estaMudo()) {
	            reproductor.muteOn();
	            ReproductorEfectos.setMute(true);
	        }
	        else{
	        	reproductor.muteOff();
	        	ReproductorEfectos.setMute(false);
	        }
	    }

}
