package vistas;

import java.util.Hashtable;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.algoBall.AlgoBall;
import model.algoBall.Equipo;
import model.consumibles.Consumible;
import model.personajes.Personaje;
import model.tablero.Posicion;
import model.tablero.Tablero;

public class VistaTablero {
	private Image suelo = new Image("file:src/vistas/imagenes/texturaSuelo.jpg");
	private int dimension;
    private Canvas canvas;
    private Equipo equipo1;
    private Equipo equipo2;
    private Tablero tablero;
    private Hashtable<Posicion,Consumible> consumibles;

    public VistaTablero(AlgoBall juego, Canvas canvas, Equipo equipo1, Equipo equipo2) {
        this.dimension = juego.getDimensionTablero();
        this.tablero = juego.getTablero();
        this.canvas = canvas;
        this.equipo1=equipo1;
        this.equipo2=equipo2;
        this.consumibles =   tablero.getPosicionesYConsumibles();
    }
    
    public Canvas getCanvas(){
    	return canvas;
    }

    public void dibujar() {
    	this.clean();
    	this.dibujarSuelo();
    	this.dibujarLineas();
        this.dibujarPersonajes();
        this.dibujarConsumibles();
    }
    private void dibujarSuelo(){
    	canvas.getGraphicsContext2D().drawImage(suelo,0, 0, canvas.getWidth(), canvas.getHeight());
    }
    private void dibujarLineas(){
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	gc.setStroke(Color.BLACK);
    	double ancho = canvas.getWidth();
    	double alto = canvas.getHeight();
    	double tamanioCasillero = ancho / dimension;
    	gc.setLineWidth(1.0);
        for (double x = 0; x <= ancho; x+=tamanioCasillero) {
            gc.moveTo(x, 0);
            gc.lineTo(x, alto);
            gc.stroke();
        }
        
        for (double y = 0; y <= alto; y+=tamanioCasillero) {
            gc.moveTo(0, y);
            gc.lineTo(ancho, y);
            gc.stroke();
        }
    }
    private void dibujarPersonajes() {
        canvas.getGraphicsContext2D().setStroke(Color.GREEN);
        canvas.getGraphicsContext2D().setLineWidth(5);
        double tamanioCasillero = canvas.getWidth() / dimension;
        
        for (Personaje personaje : equipo1){
        	Posicion posicion = personaje.getPosicion();
        	Image imagen = new Image(personaje.getImagen(), tamanioCasillero *2 /3, tamanioCasillero *2 /3, false, true);
        	canvas.getGraphicsContext2D().strokeRect(posicion.getColumna() * tamanioCasillero +1, posicion.getFila() * tamanioCasillero +1, tamanioCasillero-2, tamanioCasillero-2);
        	canvas.getGraphicsContext2D().drawImage(imagen,posicion.getColumna() * tamanioCasillero + tamanioCasillero /6, posicion.getFila() * tamanioCasillero + tamanioCasillero /6);
        }
        
        canvas.getGraphicsContext2D().setStroke(Color.RED);
        for (Personaje personaje : equipo2){
        	Posicion posicion = personaje.getPosicion();
        	Image imagen = new Image(personaje.getImagen(), tamanioCasillero *2 /3, tamanioCasillero *2 /3, false, true);
        	canvas.getGraphicsContext2D().strokeRect(posicion.getColumna() * tamanioCasillero +1, posicion.getFila() * tamanioCasillero +1, tamanioCasillero-2, tamanioCasillero-2);
        	canvas.getGraphicsContext2D().drawImage(imagen, posicion.getColumna() * tamanioCasillero + tamanioCasillero /6, posicion.getFila() * tamanioCasillero + tamanioCasillero /6);
        }
        
    }
    
    public void dibujarConsumibles(){
    	consumibles = tablero.getPosicionesYConsumibles();
    	double tamanioCasillero = canvas.getWidth() / dimension;
    	for (Posicion posicion : consumibles.keySet()){
			Consumible consumible = consumibles.get(posicion);
			Image imagen = new Image(consumible.getImagen());
			canvas.getGraphicsContext2D().drawImage(imagen, posicion.getColumna() * tamanioCasillero + tamanioCasillero /6, posicion.getFila() * tamanioCasillero + tamanioCasillero /6, tamanioCasillero *2 /3, tamanioCasillero *2 /3);
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
