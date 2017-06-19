package vista.eventos.botonMoverHandlers;
import algoBall.Equipo;
import exceptions.NoQuedanMovimientosException;
import javafx.event.ActionEvent;
import vista.eventos.BotonModificableHandler;
import vistas.Consola;
import vistas.VistaTablero;

public class BotonMoverArribaDerechaHandler extends BotonModificableHandler {

	private Equipo equipo;
	private VistaTablero vista;
	private Consola consola;
	
	public BotonMoverArribaDerechaHandler(Equipo equipo, VistaTablero vista, Consola consola) {
		this.equipo = equipo;
		this.vista = vista;
		this.consola = consola;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try{
        	this.equipo.moverArribaDerecha(personajeModificador);
            this.vista.update();
        }
        catch(NoQuedanMovimientosException error){
     	   this.consola.agregarInformacion("No te quedan movimientos!");
        }
    }
}