package vista.eventos;

import personajes.Personaje;
import vistas.BarrasDeVida;
import vistas.Consola;
import exceptions.KiInsuficienteException;
import javafx.event.ActionEvent;

public class BotonAtaqueEspecialHandler extends BotonModificableHandler{
	
	private Personaje personajeAAtacar;
	private BarrasDeVida barras;
	private Consola consola;
	
	public BotonAtaqueEspecialHandler(Personaje personaje, BarrasDeVida barras, Consola consola){
		personajeAAtacar = personaje;	
		this.barras = barras;
		this.consola = consola;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		try{
		this.personajeModificador.realizarAtaqueEspecial(personajeAAtacar);
        barras.actualizar();
		}
		catch( KiInsuficienteException error){
			this.consola.agregarInformacion("Ki Insuficiente");
		}
	}
}
