package vista.eventos.botonMoverHandlers;
import algoBall.Equipo;
import javafx.event.ActionEvent;
import vista.eventos.BotonModificableHandler;

public class BotonMoverAbajoIzquierdaHandler extends BotonModificableHandler {
	
	private Equipo equipo;
	
	public BotonMoverAbajoIzquierdaHandler(Equipo equipo) {
		this.equipo = equipo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.equipo.moverAbajoIzquierda(personajeModificador);
    }
}
