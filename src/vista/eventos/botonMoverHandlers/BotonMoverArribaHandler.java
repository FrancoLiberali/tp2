package vista.eventos.botonMoverHandlers;
import algoBall.Equipo;
import javafx.event.ActionEvent;
import vista.eventos.BotonModificableHandler;
import vistas.VistaTablero;

public class BotonMoverArribaHandler extends BotonModificableHandler {

	private Equipo equipo;
	private VistaTablero vista;
	
	public BotonMoverArribaHandler(Equipo equipo, VistaTablero vista) {
		this.equipo = equipo;
		this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.equipo.moverArriba(personajeModificador);
        this.vista.update();
    }
}
