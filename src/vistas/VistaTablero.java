package vistas;

import algoBall.AlgoBall;
import algoBall.Equipo;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import personajes.Personaje;
import tablero.Posicion;

public class VistaTablero {
	private AlgoBall juego;
	private int dimension;
    Canvas canvas;
    private Equipo equipo1;
    private Equipo equipo2;

    public VistaTablero(AlgoBall juego, Canvas canvas, Equipo equipo1, Equipo equipo2) {
        this.juego = juego;
        this.dimension = juego.getDimensionTablero();
        this.canvas = canvas;
        this.equipo1=equipo1;
        this.equipo2=equipo2;
    }
    
    public Canvas getCanvas(){
    	return canvas;
    }

    public void dibujar() {
    	this.clean();
    	this.dibujarLineas();
        this.dibujarFormas();
    }
    
    private void dibujarLineas(){
    	//la idea es dibujar las lineas del tablero pero no llegue
    	Line lineaVertical = new Line();
    	lineaVertical.setStartX(0.0f);
    	lineaVertical.setStartY(0.0f);
    	lineaVertical.setEndX(0.0f);
    	lineaVertical.setEndY(100.0f);
    }
    private void dibujarFormas() {
        canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
        int tamanioCasillero = 600 / dimension;
        for (Personaje personaje : equipo1){
        	Posicion posicion = personaje.getPosicion();
        	canvas.getGraphicsContext2D().drawImage(personaje.getImagen(),posicion.getColumna() * tamanioCasillero + tamanioCasillero /2, posicion.getFila() * tamanioCasillero + tamanioCasillero /2, 50, 50);
        }
        canvas.getGraphicsContext2D().setFill(Color.RED);
        for (Personaje personaje : equipo2){
        	Posicion posicion = personaje.getPosicion();
        	canvas.getGraphicsContext2D().drawImage(personaje.getImagen(), posicion.getColumna() * tamanioCasillero + tamanioCasillero /2, posicion.getFila() * tamanioCasillero + tamanioCasillero /2, 50, 50);
        }
        
    }

    public void clean() {

        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 600, 600);
    }

    public void update() {
        this.dibujar();
    }
}
