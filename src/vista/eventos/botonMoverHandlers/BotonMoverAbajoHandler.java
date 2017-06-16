package vista.eventos.botonMoverHandlers;
import algoBall.Equipo;
import javafx.event.ActionEvent;
import vista.eventos.BotonModificableHandler;
import vistas.VistaTablero;

public class BotonMoverAbajoHandler extends BotonModificableHandler {
	
	private Equipo equipo;
	private final VistaTablero vista;
	
	public BotonMoverAbajoHandler(Equipo equipo, VistaTablero vista) {
		this.equipo = equipo;
		this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.equipo.moverAbajo(personajeModificador);
        this.vista.update();
    }
}
