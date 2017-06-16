package vista.eventos.botonMoverHandlers;
import algoBall.Equipo;
import javafx.event.ActionEvent;
import vista.eventos.BotonModificableHandler;

public class BotonMoverAbajoDerechaHandler extends BotonModificableHandler {
	
	private Equipo equipo;
	
	public BotonMoverAbajoDerechaHandler(Equipo equipo) {
		this.equipo = equipo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.equipo.moverAbajoDerecha(personajeModificador);
    }
}
