package vistas;

import java.util.Hashtable;
import controladores.eventos.BotonFinalizarTurnoHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.algoBall.AlgoBall;
import model.algoBall.Equipo;
import model.personajes.Personaje;

public class ContenedorPrincipal extends BorderPane {
	
	private BarraDeMenu menuBar;
	private Canvas canvasCentral;
	private VistaTablero vistaTablero;
	private Consola consola;
	private Hashtable<String,CajaDeInformacionPersonaje> cajas = new Hashtable<String,CajaDeInformacionPersonaje>();
    

    public ContenedorPrincipal(Stage stage, AlgoBall juego, Equipo equipoMover, Equipo equipoAtacar,Reproductor reproductor) {
        this.setPrefWidth(75);
    	this.setMenu(stage, reproductor);
        this.setConsola();
        this.setCentro(juego, equipoMover, equipoAtacar);
        this.setBotoneraDerecha(stage, juego, equipoAtacar, equipoMover);
        this.setBotoneraIzquierda(stage, juego, equipoMover, equipoAtacar);
        Image imagen = new Image("file:src/vista/imagenes/fondoArena.jpg",Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight() +50, false, true);
        
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }
    
    private void setBotoneraDerecha(Stage stage, AlgoBall juego, Equipo equipoAtacar, Equipo equipoMover) {
    	
    	VBox contenedorVertical = new VBox();
        contenedorVertical.setSpacing(5);
        contenedorVertical.setPadding(new Insets(5));
        contenedorVertical.setPrefWidth(300);
        
        for (Personaje personaje : equipoAtacar){
        	CajaDeInformacionPersonaje caja = new CajaDeInformacionPersonaje(personaje);
        	cajas.put(personaje.getNombre(), caja);
        	contenedorVertical.getChildren().add(caja);
        }
        
        for (Personaje personaje : equipoMover){
        	CajaDeInformacionPersonaje caja = new CajaDeInformacionPersonaje(personaje);
        	cajas.put(personaje.getNombre(), caja);
            contenedorVertical.getChildren().add(caja);
        }
        
        this.setRight(contenedorVertical);

    }
    
    private void setBotoneraIzquierda(Stage stage, AlgoBall juego, Equipo equipoMover, Equipo equipoAtacar) {
    	
    	VBox contenedorVertical = new VBox();
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        contenedorVertical.setPrefWidth(300);
        
        BotoneraIzquierda botonera1 = new BotoneraIzquierda(juego, equipoMover, equipoAtacar, vistaTablero, consola, cajas);
        contenedorVertical.getChildren().add(botonera1);
        BotoneraIzquierda botonera2 = new BotoneraIzquierda(juego, equipoAtacar, equipoMover, vistaTablero, consola, cajas);
        botonera1.setSiguiente(botonera2);
        botonera2.setSiguiente(botonera1);
    	        
        Button finalizarTurno = new Button();
        finalizarTurno.setText("Finalizar turno");
        BotonFinalizarTurnoHandler finalizarHandler = new BotonFinalizarTurnoHandler(juego, consola, botonera1, contenedorVertical, finalizarTurno, vistaTablero);
        finalizarTurno.setOnAction(finalizarHandler);
        contenedorVertical.getChildren().add(finalizarTurno);
        
        this.setLeft(contenedorVertical);

    }

    private void setMenu(Stage stage,Reproductor reproductor) {
        this.menuBar = new BarraDeMenu(stage, reproductor);
        this.setTop(menuBar);
    }

    public void setCentro(AlgoBall juego, Equipo equipo1, Equipo equipo2) {
    	canvasCentral = new Canvas (600,600);
        vistaTablero = new VistaTablero(juego, canvasCentral, equipo1, equipo2);
    	vistaTablero.dibujar();
        VBox contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
        //Image imagen = new Image("file:src/vista/imagenes/fondo-verde.jpg");
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        //contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
    }
  
    private void setConsola() {

      this.consola = new Consola();
      this.setBottom(consola);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
}
