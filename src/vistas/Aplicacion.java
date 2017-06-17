package vistas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import algoBall.Equipo;

import java.io.File;

import algoBall.AlgoBall;
import vista.eventos.AplicacionOnKeyPressEventHandler;
import vistas.Reproductor;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("Dragon AlgoBall");

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(this, stage);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);
        contenedorBienvenidos.requestFocus();

        // add handler to this:
        // stage.setOnCloseRequest()

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);
     
   
       // Reproductor reproductor =new Reproductor();
        //reproductor.reproducionAutomitica(true);

        
        stage.show();

    }
    
    public Scene crearJuego(Stage stage, String nombre1, String nombre2){
    	AlgoBall juego = new AlgoBall(nombre1,nombre2);
    	
    	Equipo equipo1 = juego.getEquipoActual();
        Equipo equipo2 = juego.getEquipoSiguiente();
        
        ContenedorPrincipal contenedorTurnoJugador1 = new ContenedorPrincipal(stage, juego, equipo1, equipo2);
        ContenedorPrincipal contenedorTurnoJugador2 = new ContenedorPrincipal(stage, juego, equipo2, equipo1);
        
        Scene escenaJugador2 = new Scene(contenedorTurnoJugador2, 640, 480);
        Scene escenaJugador1 = new Scene(contenedorTurnoJugador1, 640, 480);
        contenedorTurnoJugador1.setProximaEscena(escenaJugador2, contenedorTurnoJugador2.getVista());
        contenedorTurnoJugador2.setProximaEscena(escenaJugador1, contenedorTurnoJugador1.getVista());

        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorTurnoJugador1.getBarraDeMenu(), contenedorTurnoJugador1.getBarraDeMenu());
        escenaJugador1.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
        escenaJugador2.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
        
        return escenaJugador1;
    }
}