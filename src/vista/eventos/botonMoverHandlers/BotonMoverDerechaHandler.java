package vista.eventos.botonMoverHandlers;
import algoBall.Equipo;
import javafx.event.ActionEvent;
import vista.eventos.BotonModificableHandler;
import vistas.VistaTablero;

public class BotonMoverDerechaHandler extends BotonModificableHandler {

	private Equipo equipo;
	private VistaTablero vista;
	
	public BotonMoverDerechaHandler(Equipo equipo, VistaTablero vista) {
		this.equipo = equipo;
		this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.equipo.moverDerecha(personajeModificador);
        this.vista.update();
    }
}
