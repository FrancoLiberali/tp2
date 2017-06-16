package vista.eventos.botonMoverHandlers;
import algoBall.Equipo;
import javafx.event.ActionEvent;
import vista.eventos.BotonModificableHandler;

public class BotonMoverDerechaHandler extends BotonModificableHandler {

private Equipo equipo;
	
	public BotonMoverDerechaHandler(Equipo equipo) {
		this.equipo = equipo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.equipo.moverDerecha(personajeModificador);
    }
}
