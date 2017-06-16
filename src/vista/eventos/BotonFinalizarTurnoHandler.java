package vista.eventos;

import algoBall.AlgoBall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vistas.VistaTablero;

public class BotonFinalizarTurnoHandler implements EventHandler<ActionEvent> {
	
	Stage stage;
    Scene proximaEscena;
    AlgoBall juego;
    VistaTablero proximaVista;

    public BotonFinalizarTurnoHandler(Stage stage, AlgoBall juego) {
        this.stage = stage;
        this.juego = juego;
    }
    
    public void setProximaEscena(Scene proximaEscena){
    	this.proximaEscena = proximaEscena;
    }
    
    public void setProximaVista(VistaTablero proximaVista){
    	this.proximaVista = proximaVista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        proximaVista.update();
    	stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        juego.finalizarTurno();
    }
}