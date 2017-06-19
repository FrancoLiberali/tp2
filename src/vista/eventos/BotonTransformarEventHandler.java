package vista.eventos;

import algoBall.Equipo;
import javafx.event.ActionEvent;
import vistas.VistaTablero;

public class BotonTransformarEventHandler extends BotonModificableHandler {
	
	Equipo equipo;
	VistaTablero vista;
	
	public BotonTransformarEventHandler(Equipo equipo,VistaTablero vista){
		this.equipo = equipo;
		this. vista = vista;
	}

	@Override
	public void handle(ActionEvent arg0) {
		equipo.transformar(this.personajeModificador);
		vista.update();
	}
	
	

}
