package vistas;

import algoBall.AlgoBall;
import algoBall.Equipo;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
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
        this.dibujarFormas();
    }

    private void dibujarFormas() {
        this.clean();
        canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
       for (Personaje personaje : equipo1){
        	Posicion posicion = personaje.getPosicion();
        	canvas.getGraphicsContext2D().fillOval(posicion.getColumna() * 100 +50, posicion.getFila() * 100+50, 10, 10);
        	//canvas.getGraphicsContext2D().fillOval(0, 0, 10, 10);
        }
        canvas.getGraphicsContext2D().setFill(Color.RED);
        for (Personaje personaje : equipo2){
        	Posicion posicion = personaje.getPosicion();
        	canvas.getGraphicsContext2D().fillRect(posicion.getColumna() * 100+50, posicion.getFila() * 100+50, 10, 10);
        	//canvas.getGraphicsContext2D().fillRect(200, 200, 10, 10);
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
