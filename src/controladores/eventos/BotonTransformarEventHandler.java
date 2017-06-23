package controladores.eventos;

import javafx.event.ActionEvent;
import model.algoBall.Equipo;
import model.exceptions.KiInsuficienteException;
import model.exceptions.NoCumpleCondicionesDeTransformacionException;
import model.exceptions.YaNoPuedeEvolucionarException;
import vistas.Consola;
import vistas.VistaTablero;

public class BotonTransformarEventHandler extends BotonModificableHandler {
	
	private Equipo equipo;
	private VistaTablero vista;
	private Consola consola;
	
	public BotonTransformarEventHandler(Equipo equipo,VistaTablero vista, Consola consola){
		this.equipo = equipo;
		this. vista = vista;
		this.consola = consola;
	}

	@Override
	public void handle(ActionEvent arg0) {
		try{
			equipo.transformar(this.personajeModificador);
			vista.update();
		}
		catch (YaNoPuedeEvolucionarException error){
			this.consola.agregarInformacion("Este personaje ya no posee una proxima evolucion");
		}
		catch (KiInsuficienteException error){
			this.consola.agregarInformacion("El ki del personaje no es suficiente para evolucionar");
		}
		catch (NoCumpleCondicionesDeTransformacionException error){
			this.consola.agregarInformacion("Este personaje aun no cumple todas las condiciones para tranformarse");
		}
	}
	
	

}
