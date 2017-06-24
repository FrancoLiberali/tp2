package controladores.eventos;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class OnEnterPressEventHandler implements EventHandler<KeyEvent>{

	private Button botonEntrar;
	
	public OnEnterPressEventHandler(Button botonEntrar){
		this.botonEntrar = botonEntrar;
	}
	@Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            botonEntrar.fire();
        }
    }
}
