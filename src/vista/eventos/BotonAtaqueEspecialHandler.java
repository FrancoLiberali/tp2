package vista.eventos;

import personajes.Personaje;
import javafx.event.ActionEvent;

public class BotonAtaqueEspecialHandler extends BotonModificableHandler{
	
	private Personaje personajeAAtacar;
	public BotonAtaqueEspecialHandler(Personaje personaje){
		personajeAAtacar = personaje;		
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
        this.personajeModificador.realizarAtaqueEspecial(personajeAAtacar);
    }
}
