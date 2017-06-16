package vista.eventos.botonMoverHandlers;
import algoBall.Equipo;
import javafx.event.ActionEvent;
import vista.eventos.BotonModificableHandler;

public class BotonMoverAbajoHandler extends BotonModificableHandler {
	
	private Equipo equipo;
	
	public BotonMoverAbajoHandler(Equipo equipo) {
		this.equipo = equipo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.equipo.moverAbajo(personajeModificador);
    }
}
