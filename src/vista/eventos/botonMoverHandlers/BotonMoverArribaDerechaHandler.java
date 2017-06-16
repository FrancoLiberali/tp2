package vista.eventos.botonMoverHandlers;
import algoBall.Equipo;
import javafx.event.ActionEvent;
import vista.eventos.BotonModificableHandler;

public class BotonMoverArribaDerechaHandler extends BotonModificableHandler {

	private Equipo equipo;
	
	public BotonMoverArribaDerechaHandler(Equipo equipo) {
		this.equipo = equipo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.equipo.moverArribaDerecha(personajeModificador);
    }
}
