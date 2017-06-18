package vista.eventos;

import javafx.event.ActionEvent;
import personajes.Personaje;

public class BotonTransformarHandler extends BotonModificableHandler {
	private Personaje personajeATransformar;
	
	public BotonTransformarHandler(Personaje personaje){
		this.personajeATransformar = personaje;
	}
	@Override
	public void handle(ActionEvent actionEvent) {
		this.personajeATransformar.transformar();
		//this.stats.actualizar();
	}

}
