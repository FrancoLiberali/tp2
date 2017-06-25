package vistas;

import controladores.eventos.AplicacionOnKeyPressEventHandler;
import controladores.eventos.OnCloseRequestEventHandler;
import controladores.eventos.OnEnterPressEventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.algoBall.AlgoBall;
import model.algoBall.Equipo;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("Dragon AlgoBall");
        Screen screen = Screen.getPrimary();
        
        Reproductor reproductor = new Reproductor();
        reproductor.reproducionAutomitica(true);
        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(this, stage, screen, reproductor);
        
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);
        contenedorBienvenidos.requestFocus();

        stage.setOnCloseRequest(new OnCloseRequestEventHandler());
        Button botonEntrar = contenedorBienvenidos.getBotonEntrar();
        OnEnterPressEventHandler OnEnterPressEventHandler = new OnEnterPressEventHandler(botonEntrar);
        escenaBienvenidos.setOnKeyPressed(OnEnterPressEventHandler);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        
        stage.show();

    }
    
    public Scene crearJuego(Stage stage, String nombre1, String nombre2,Reproductor reproductor){
    	AlgoBall juego = new AlgoBall(nombre1,nombre2);
    	
    	Equipo equipo1 = juego.getEquipoActual();
        Equipo equipo2 = juego.getEquipoSiguiente();
        //PanelDeCaracteristicas caracteristicasEquipo1 = new PanelDeCaracteristicas(equipo1.getPanelCaracteristicas());
        //PanelDeCaracteristicas caracteristicasEquipo2 = new PanelDeCaracteristicas(equipo2.getPanelCaracteristicas());
        
        ContenedorPrincipal contenedorTurnoJugador1 = new ContenedorPrincipal(stage, juego, equipo1, equipo2,reproductor);
        ContenedorPrincipal contenedorTurnoJugador2 = new ContenedorPrincipal(stage, juego, equipo2, equipo1,reproductor);
        
        Scene escenaJugador2 = new Scene(contenedorTurnoJugador2, 640, 480);
        Scene escenaJugador1 = new Scene(contenedorTurnoJugador1, 640, 480);
        contenedorTurnoJugador1.setProximaEscena(escenaJugador2, contenedorTurnoJugador2.getVista());
        contenedorTurnoJugador2.setProximaEscena(escenaJugador1, contenedorTurnoJugador1.getVista());
        contenedorTurnoJugador1.setProximasBarras(contenedorTurnoJugador2.getBarras());
        contenedorTurnoJugador2.setProximasBarras(contenedorTurnoJugador1.getBarras());

        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorTurnoJugador1.getBarraDeMenu(), contenedorTurnoJugador1.getBarraDeMenu());
        escenaJugador1.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
        escenaJugador2.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
        
        return escenaJugador1;
    }
}