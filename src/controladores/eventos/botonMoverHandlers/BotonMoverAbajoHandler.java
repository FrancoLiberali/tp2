package controladores.eventos.botonMoverHandlers;
import java.util.Hashtable;

import controladores.eventos.BotonModificableHandler;
import javafx.event.ActionEvent;
import model.algoBall.Equipo;
import model.personajes.elementos.Direccion;
import vistas.CajaDeInformacionPersonaje;
import vistas.Consola;
import vistas.VistaTablero;

public class BotonMoverAbajoHandler extends BotonModificableHandler {
	
	private Equipo equipo;
	private final VistaTablero vista;
	private BotonMoverHandler moverHandler;
	
	public BotonMoverAbajoHandler(Equipo equipo, VistaTablero vista, Consola consola, Hashtable<String,CajaDeInformacionPersonaje> cajas) {
		this.equipo = equipo;
		this.vista = vista;
		this.moverHandler = new BotonMoverHandler(consola, cajas);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	moverHandler.mover(equipo, personajeModificador, Direccion.abajo());
    	this.vista.update();
    }
}