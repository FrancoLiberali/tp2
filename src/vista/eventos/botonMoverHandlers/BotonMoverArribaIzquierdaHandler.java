package vista.eventos.botonMoverHandlers;
import algoBall.Equipo;
import javafx.event.ActionEvent;
import vista.eventos.BotonModificableHandler;

public class BotonMoverArribaIzquierdaHandler extends BotonModificableHandler {

	private Equipo equipo;
	
	public BotonMoverArribaIzquierdaHandler(Equipo equipo) {
		this.equipo = equipo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.equipo.moverArribaIzquierda(personajeModificador);
    }
}
