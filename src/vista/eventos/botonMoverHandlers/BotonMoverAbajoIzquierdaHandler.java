package vista.eventos.botonMoverHandlers;
import algoBall.Equipo;
import exceptions.NoQuedanMovimientosException;
import javafx.event.ActionEvent;
import vista.eventos.BotonModificableHandler;
import vistas.Consola;
import vistas.VistaTablero;

public class BotonMoverAbajoIzquierdaHandler extends BotonModificableHandler {
	
	private Equipo equipo;
	private final VistaTablero vista;
	private Consola consola;
	
	public BotonMoverAbajoIzquierdaHandler(Equipo equipo, VistaTablero vista, Consola consola) {
		this.equipo = equipo;
		this.vista = vista;
		this.consola = consola;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try{
        	this.equipo.moverAbajoIzquierda(personajeModificador);
            this.vista.update();
        }
        catch(NoQuedanMovimientosException error){
     	   this.consola.agregarInformacion("No te quedan movimientos!");
        }
    }
}
