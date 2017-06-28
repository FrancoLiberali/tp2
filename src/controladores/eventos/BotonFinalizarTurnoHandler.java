package controladores.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.algoBall.AlgoBall;
import vistas.BotoneraIzquierda;
import vistas.Consola;

import vistas.VistaTablero;

public class BotonFinalizarTurnoHandler implements EventHandler<ActionEvent> {
	
	private AlgoBall juego;
    private BotoneraIzquierda botonera;
    private VBox contenedor;
    private Button finalizarTurno;
    private VistaTablero vistaTablero; 
    
    public BotonFinalizarTurnoHandler(AlgoBall juego, Consola consola, BotoneraIzquierda botonera, VBox contenedor, Button finalizarTurno, VistaTablero vista) {
        this.juego = juego;
        this.botonera = botonera;
        this.contenedor = contenedor;
        this.finalizarTurno = finalizarTurno;
        this.vistaTablero = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.finalizarTurno();
        vistaTablero.update();
        botonera = botonera.getSiguiente();
        botonera.actualizar();
        contenedor.getChildren().clear();
        contenedor.getChildren().add(botonera);   
        contenedor.getChildren().add(finalizarTurno); 
    	
    }
}