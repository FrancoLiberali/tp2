package vista.eventos;

import personajes.Personaje;
import javafx.event.ActionEvent;

public class BotonAtaqueBasicoHandler extends BotonModificableHandler{
	
	private Personaje personajeAAtacar;
	public BotonAtaqueBasicoHandler(Personaje personaje){
		personajeAAtacar = personaje;		
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
        this.personajeModificador.realizarAtaqueBasico(personajeAAtacar);
    }
}
