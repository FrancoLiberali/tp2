package vista.eventos;

import algoBall.AlgoBall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vistas.BarrasDeVida;
import vistas.Consola;
import vistas.VistaTablero;

public class BotonFinalizarTurnoHandler implements EventHandler<ActionEvent> {
	
	Stage stage;
    Scene proximaEscena;
    AlgoBall juego;
    VistaTablero proximaVista;
    BarrasDeVida proximasBarras;
    private Consola consola;
    
    public BotonFinalizarTurnoHandler(Stage stage, AlgoBall juego, Consola consola) {
        this.stage = stage;
        this.juego = juego;
    }
    
    public void setProximaEscena(Scene proximaEscena){
    	this.proximaEscena = proximaEscena;
    }
    
    public void setProximaVista(VistaTablero proximaVista){
    	this.proximaVista = proximaVista;
    }
    
    public void setProximasBarras(BarrasDeVida proximasBarras){
    	this.proximasBarras = proximasBarras;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        proximaVista.update();
    	proximasBarras.actualizar();
    	stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        juego.finalizarTurno();
        
    }
}