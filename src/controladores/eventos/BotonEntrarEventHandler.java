package controladores.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import vistas.Aplicacion;
import vistas.Reproductor;
import vistas.ReproductorEfectos;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {
	
	private Aplicacion aplicacion;
    private Stage stage;
    private TextField nombre1;
    private TextField nombre2;
    private Label label1;
    private Label label2;
    private Reproductor reproductor;

    public BotonEntrarEventHandler(Aplicacion aplicacion, Stage stage, Label label1, TextField nombre1, Label label2, TextField nombre2,Reproductor reproductor) {
        this.aplicacion = aplicacion;
    	this.stage = stage;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.label1 = label1;
        this.label2 = label2;
        this.reproductor = reproductor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	if (this.nombre1.getText().trim().equals("")) {
    		this.label2.setText("");
            this.label1.setText("Debe ingresar un nombre para el jugador de los Guerreros Z");
            this.label1.setTextFill(Color.web("#FF0000"));
            this.nombre1.requestFocus();
    	}
    	
    	else if (this.nombre2.getText().trim().equals("")) {
    		this.label1.setText("");
            this.label2.setText("Debe ingresar un nombre para el jugador de los Enemigos de la Tierra");
            this.label2.setTextFill(Color.web("#FF0000"));
            this.nombre2.requestFocus();
    	}
    	else{
    		Scene proximaEscena = aplicacion.crearJuego(stage, this.nombre1.getText(), this.nombre2.getText(), reproductor);
    		stage.setScene(proximaEscena);
            stage.setFullScreenExitHint("");
            stage.setFullScreen(true);
        	ReproductorEfectos.inicializarReproductorFX();
    	}
        
    }
}
