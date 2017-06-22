package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.personajes.Personaje;
import vistas.PanelDeCaracteristicas;

public class OnMouseTransformarEventHandler implements EventHandler<ActionEvent>  {
	PanelDeCaracteristicas panel;
	Personaje personaje;
	
	public  OnMouseTransformarEventHandler(	PanelDeCaracteristicas panel,Personaje personaje){
		this.panel = panel;
		this.personaje = personaje;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		panel.setearBotonTransformar(personaje);
	}

}
