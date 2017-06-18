package vista.eventos;

import algoBall.Equipo;
import javafx.event.ActionEvent;

public class BotonTransformarEventHandler extends BotonModificableHandler {
	
	Equipo equipo;
	
	public BotonTransformarEventHandler(Equipo equipo){
		this.equipo = equipo;

	}

	@Override
	public void handle(ActionEvent arg0) {
		equipo.transformar(this.personajeModificador);
		
	}
	
	

}
