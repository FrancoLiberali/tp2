package vista.eventos.botonMoverHandlers;
import algoBall.Equipo;
import javafx.event.ActionEvent;
import vista.eventos.BotonModificableHandler;

public class BotonMoverIzquierdaHandler extends BotonModificableHandler {

	private Equipo equipo;
	
	public BotonMoverIzquierdaHandler(Equipo equipo) {
		this.equipo = equipo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.equipo.moverIzquierda(personajeModificador);
    }
}
