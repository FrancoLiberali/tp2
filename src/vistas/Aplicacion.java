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
        
        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(this, stage, screen);
        
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
    
    public Scene crearJuego(Stage stage, String nombre1, String nombre2){
    	AlgoBall juego = new AlgoBall(nombre1,nombre2);
    	
    	Equipo equipo1 = juego.getEquipoActual();
        Equipo equipo2 = juego.getEquipoSiguiente();
        
        ContenedorPrincipal contenedor = new ContenedorPrincipal(stage, juego, equipo1, equipo2);
        Scene escena = new Scene(contenedor, 640, 480);

        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedor.getBarraDeMenu());
        escena.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
        
        return escena;
    }
}