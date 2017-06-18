package vista.eventos.botonMoverHandlers;
import algoBall.Equipo;
import javafx.event.ActionEvent;
import vista.eventos.BotonModificableHandler;
import vistas.VistaTablero;

public class BotonMoverAbajoDerechaHandler extends BotonModificableHandler {
	
	private Equipo equipo;
	private final VistaTablero vista;
	
	public BotonMoverAbajoDerechaHandler(Equipo equipo, VistaTablero vista) {
		this.equipo = equipo;
		this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.equipo.moverAbajoDerecha(personajeModificador);
        this.vista.update();
    }
}

