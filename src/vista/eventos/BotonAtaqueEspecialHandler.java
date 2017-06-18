package vista.eventos;

import personajes.Personaje;
import vistas.BarrasDeVida;
import javafx.event.ActionEvent;

public class BotonAtaqueEspecialHandler extends BotonModificableHandler{
	
	private Personaje personajeAAtacar;
	private BarrasDeVida barras;
	
	public BotonAtaqueEspecialHandler(Personaje personaje, BarrasDeVida barras){
		personajeAAtacar = personaje;	
		this.barras = barras;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
        this.personajeModificador.realizarAtaqueEspecial(personajeAAtacar);
        barras.actualizar();
    }
}
