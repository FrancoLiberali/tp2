package controladores.eventos;

import java.util.Optional;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

public class OnCloseRequestEventHandler implements EventHandler<WindowEvent>{
	
	@Override
    public void handle(WindowEvent windowEvent) {
        Alert alert = new Alert(AlertType.CONFIRMATION, "¿Seguro que desea salir?");
        alert.setHeaderText("Al confirmar salida sus avance en el juego se perdera");
        Button exitButton = (Button) alert.getDialogPane().lookupButton(
                ButtonType.OK
        );
        exitButton.setText("Cerrar");
        Optional<ButtonType> closeResponse = alert.showAndWait();
        if (!ButtonType.OK.equals(closeResponse.get())) {
        	windowEvent.consume();
        }
    }

}
