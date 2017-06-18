package vista.eventos.botonMoverHandlers;
import algoBall.Equipo;
import javafx.event.ActionEvent;
import vista.eventos.BotonModificableHandler;
import vistas.VistaTablero;

public class BotonMoverAbajoIzquierdaHandler extends BotonModificableHandler {
	
	private Equipo equipo;
	private final VistaTablero vista;
	
	public BotonMoverAbajoIzquierdaHandler(Equipo equipo, VistaTablero vista) {
		this.equipo = equipo;
		this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.equipo.moverAbajoIzquierda(personajeModificador);
        this.vista.update();
    }
}
