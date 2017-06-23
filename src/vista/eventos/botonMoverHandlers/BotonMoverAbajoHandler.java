package vista.eventos.botonMoverHandlers;
import javafx.event.ActionEvent;
import model.algoBall.Equipo;
import model.personajes.elementos.Direccion;
import vista.eventos.BotonModificableHandler;
import vistas.Consola;
import vistas.VistaTablero;

public class BotonMoverAbajoHandler extends BotonModificableHandler {
	
	private Equipo equipo;
	private final VistaTablero vista;
	private BotonMoverHandler moverHandler;
	
	public BotonMoverAbajoHandler(Equipo equipo, VistaTablero vista, Consola consola) {
		this.equipo = equipo;
		this.vista = vista;
		this.moverHandler = new BotonMoverHandler(consola);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	moverHandler.mover(equipo, personajeModificador, Direccion.abajo());
    	this.vista.update();
    }
}