package vista.eventos.botonMoverHandlers;
import algoBall.Equipo;
import exceptions.NoQuedanMovimientosException;
import javafx.event.ActionEvent;
import vista.eventos.BotonModificableHandler;
import vistas.Consola;
import vistas.VistaTablero;

public class BotonMoverAbajoHandler extends BotonModificableHandler {
	
	private Equipo equipo;
	private final VistaTablero vista;
	private Consola consola;
	
	public BotonMoverAbajoHandler(Equipo equipo, VistaTablero vista, Consola consola) {
		this.equipo = equipo;
		this.vista = vista;
		this.consola = consola;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try{
        	this.equipo.moverAbajo(personajeModificador);
          	this.vista.update();
        }
        catch(NoQuedanMovimientosException error){
     	   this.consola.agregarInformacion("No te quedan movimientos!");
        }
    }
}