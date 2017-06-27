package controladores.eventos;

import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import model.personajes.Personaje;
import vistas.LabelModificable;

public class ModificadorDePersonaje implements ChangeListener<Toggle>{
	
	private List<Button> botones;
    private List<BotonModificableHandler> handlersBotones;
    private final ToggleGroup grupo;
	private LabelModificable danioBasicos;
	private LabelModificable danioEspecial;
	private LabelModificable costoTransformar;
	private LabelModificable costoEspecial;
    
    
    public ModificadorDePersonaje(ToggleGroup grupo, List<Button> botones, List<BotonModificableHandler> handlersBotones, LabelModificable danioBasicos,LabelModificable danioEspecial,LabelModificable costoEspecial, LabelModificable costoTransformar){
    	this.botones = botones;
    	this.handlersBotones = handlersBotones;
    	this.grupo = grupo;
    	this.danioBasicos = danioBasicos;
    	this.danioEspecial = danioEspecial;
    	this.costoEspecial = costoEspecial;
    	this.costoTransformar = costoTransformar;
    }
    
	public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) {
		if (new_toggle == null){
			for (Button boton : botones){
				boton.setDisable(true);
			}
			danioBasicos.setDisable(true);
			danioEspecial.setDisable(true);
			costoEspecial.setDisable(true);
			costoTransformar.setDisable(true);
		}
		else{
			Personaje personaje = (Personaje) grupo.getSelectedToggle().getUserData();
			for (Button boton : botones){
				boton.setDisable(false);
			}
			for (BotonModificableHandler handler : handlersBotones){
				handler.setPersonaje(personaje);
			}
			danioBasicos.modificar("danio(PdP)", personaje.getPoderDePelea());
			danioEspecial.modificar("danio", personaje.getDanioAtaqueEspecial());
			costoEspecial.modificar("costo", personaje.getCostoAtaqueEspecial());
			costoTransformar.modificar("costo", personaje.getCostoTransformar());
		}
	}
}
