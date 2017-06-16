package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("Dragon AlgoBall 3.0");
        String mensaje = "Creadores: Franco Liberali, Bautista Canavese, Matias Leal y Matias Iglesias \nNingun derecho reservado";
        alert.setContentText(mensaje);
        alert.show();
    }
}
