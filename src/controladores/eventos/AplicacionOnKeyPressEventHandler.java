package controladores.eventos;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import vistas.BarraDeMenu;

public class AplicacionOnKeyPressEventHandler implements EventHandler<KeyEvent> {

    private Stage stage;
    private BarraDeMenu menuBar1;
    private BarraDeMenu menuBar2;

    public AplicacionOnKeyPressEventHandler(Stage stage, BarraDeMenu menuBar1, BarraDeMenu menuBar2) {
        this.stage = stage;
        this.menuBar1 = menuBar1;
        this.menuBar2 = menuBar2;
    }

    @Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ESCAPE) {
            stage.setMaximized(true);
            menuBar1.aplicacionMaximizada();
            menuBar2.aplicacionMaximizada();
        }
    }
}
