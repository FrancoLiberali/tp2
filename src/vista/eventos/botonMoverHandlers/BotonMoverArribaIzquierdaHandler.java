package vista.eventos.botonMoverHandlers;
import algoBall.Equipo;
import javafx.event.ActionEvent;
import vista.eventos.BotonModificableHandler;
import vistas.VistaTablero;

public class BotonMoverArribaIzquierdaHandler extends BotonModificableHandler {

	private Equipo equipo;
	private VistaTablero vista;
	
	public BotonMoverArribaIzquierdaHandler(Equipo equipo, VistaTablero vista) {
		this.equipo = equipo;
		this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.equipo.moverArribaIzquierda(personajeModificador);
        this.vista.update();
    }
}
