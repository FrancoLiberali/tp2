package controladores.eventos.botonMoverHandlers;
import controladores.eventos.BotonModificableHandler;
import javafx.event.ActionEvent;
import model.algoBall.Equipo;
import model.personajes.elementos.Direccion;
import vistas.Consola;
import vistas.VistaTablero;

public class BotonMoverAbajoIzquierdaHandler extends BotonModificableHandler {
	
	private Equipo equipo;
	private final VistaTablero vista;
	private BotonMoverHandler moverHandler;
	
	public BotonMoverAbajoIzquierdaHandler(Equipo equipo, VistaTablero vista, Consola consola) {
		this.equipo = equipo;
		this.vista = vista;
		this.moverHandler = new BotonMoverHandler(consola);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	moverHandler.mover(equipo, personajeModificador, Direccion.abajoIzquierda());
    	this.vista.update();
    }
}
