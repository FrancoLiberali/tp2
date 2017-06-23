package controladores.eventos;

import javafx.event.ActionEvent;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import vistas.Reproductor;

public class MuteOnOffEventHandler  extends BotonModificableHandler {
	
	ToggleButton boton;
	Reproductor reproductor;
	
	public MuteOnOffEventHandler(ToggleButton boton,Reproductor reproductor){
		
		this.boton = boton;
		this.reproductor = reproductor;
	}

	@Override
	public void handle(ActionEvent arg0) {
		if(boton.isSelected()){
			 Image imagenOff = new Image("file:src/vista/imagenes/sonidoOff.png" );
		     ImageView imagenBoton = new ImageView(imagenOff);
		     imagenBoton.setFitWidth(50);
		     imagenBoton.setPreserveRatio(true);
		     boton.setGraphic(imagenBoton);
		     reproductor.muteOn();
		}
		else{
			Image imagenOn = new Image("file:src/vista/imagenes/sonidoOn.png" );
			ImageView imagenBoton = new ImageView(imagenOn);
			imagenBoton.setFitWidth(50);
			imagenBoton.setPreserveRatio(true);
			boton.setGraphic(imagenBoton);
			reproductor.muteOff();
		}		
		
	}

}
