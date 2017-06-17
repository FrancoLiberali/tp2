package vista.eventos;

import java.util.List;

import personajes.Personaje;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class ModificadorDePersonaje implements ChangeListener<Toggle>{
	
	List<Button> botones;
    List<BotonModificableHandler> handlersBotones;
    final ToggleGroup grupo;
    
    public ModificadorDePersonaje(ToggleGroup grupo, List<Button> botones, List<BotonModificableHandler> handlersBotones){
    	this.botones = botones;
    	this.handlersBotones = handlersBotones;
    	this.grupo = grupo;
    }
    
	public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) {
		if (new_toggle == null){
			for (Button boton : botones){
				boton.setDisable(true);
			}
		}
		else{
			for (Button boton : botones){
				boton.setDisable(false);
			}
			for (BotonModificableHandler handler : handlersBotones){
				handler.setPersonaje((Personaje) grupo.getSelectedToggle().getUserData());
			}
		}

	}
}
