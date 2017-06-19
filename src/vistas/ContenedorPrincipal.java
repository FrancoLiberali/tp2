package vistas;

import java.util.ArrayList;
import java.util.List;

import algoBall.AlgoBall;
import algoBall.Equipo;
import funcionamientoPersonaje.elementos.PanelCaracteristicas;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import personajes.Personaje;
import vista.eventos.BotonAtaqueBasicoHandler;
import vista.eventos.BotonAtaqueEspecialHandler;
import vista.eventos.BotonEntrarEventHandler;
import vista.eventos.BotonFinalizarTurnoHandler;
import vista.eventos.BotonModificableHandler;
import vista.eventos.BotonTransformarEventHandler;
import vista.eventos.ModificadorDePersonaje;
import vista.eventos.botonMoverHandlers.BotonMoverAbajoDerechaHandler;
import vista.eventos.botonMoverHandlers.BotonMoverAbajoHandler;
import vista.eventos.botonMoverHandlers.BotonMoverAbajoIzquierdaHandler;
import vista.eventos.botonMoverHandlers.BotonMoverArribaDerechaHandler;
import vista.eventos.botonMoverHandlers.BotonMoverArribaHandler;
import vista.eventos.botonMoverHandlers.BotonMoverArribaIzquierdaHandler;
import vista.eventos.botonMoverHandlers.BotonMoverDerechaHandler;
import vista.eventos.botonMoverHandlers.BotonMoverIzquierdaHandler;

public class ContenedorPrincipal extends BorderPane {
	
	List<Button> botones = new ArrayList<Button>();
    List<BotonModificableHandler> handlersBotones = new ArrayList<BotonModificableHandler>();
    BarraDeMenu menuBar;
	private BotonFinalizarTurnoHandler finalizarTurnoHandler;
	final ToggleGroup grupo = new ToggleGroup();
	private Canvas canvasCentral;
	private VistaTablero vistaTablero;
	private BarrasDeVida barras;
    

    public ContenedorPrincipal(Stage stage, AlgoBall juego, Equipo agrupacionMover, Equipo agrupacionAtacar,Reproductor reproductor,PanelDeCaracteristicas panelCaracteristicas) {
        this.setPrefWidth(75);
    	this.setMenu(stage, reproductor);
        this.setConsola();
        this.setCentro(juego, agrupacionMover, agrupacionAtacar);
        this.setBotoneraDerecha(stage, juego, agrupacionAtacar, agrupacionMover);
        this.setBotoneraIzquierda(juego, agrupacionMover, agrupacionAtacar, panelCaracteristicas);
        
    }
    
    private void setBotoneraDerecha(Stage stage, AlgoBall juego, Equipo agrupacionAtacar, Equipo equipoMover) {
    	
    	barras = new BarrasDeVida(agrupacionAtacar, equipoMover);
    	VBox contenedorVertical = new VBox();
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        Label labelBasicos = new Label("Realizar ataque basico sobre:");
        contenedorVertical.getChildren().add(labelBasicos);
        for (Personaje personaje : agrupacionAtacar){
        	Button boton = this.setBotonAtaqueBasicoPersonaje(personaje.getNombre(), personaje, barras);
        	contenedorVertical.getChildren().add(boton);
        }
        Label labelEspecial = new Label("Realizar ataque especial sobre:");
        contenedorVertical.getChildren().add(labelEspecial);
        for (Personaje personaje : agrupacionAtacar){
        	Button boton = this.setBotonAtaqueEspecialPersonaje(personaje.getNombre(), personaje, barras);
        	contenedorVertical.getChildren().add(boton);
        }
        Button finalizarTurno = new Button();
        finalizarTurno.setText("Finalizar turno");
        BotonFinalizarTurnoHandler finalizarHandler = new BotonFinalizarTurnoHandler(stage, juego);
        this.finalizarTurnoHandler = finalizarHandler;
        finalizarTurno.setOnAction(finalizarHandler);
        contenedorVertical.getChildren().add(finalizarTurno);
        contenedorVertical.getChildren().add(barras);
        this.setRight(contenedorVertical);

    }
    private Button setBotonAtaqueBasicoPersonaje(String text, Personaje personaje, BarrasDeVida barras){
    	Button boton = new Button();
    	boton.setText(text);
    	boton.setMinWidth(this.getPrefWidth());
    	botones.add(boton);
    	BotonAtaqueBasicoHandler ataqueHandler = new BotonAtaqueBasicoHandler(personaje, barras);
    	boton.setOnAction(ataqueHandler);
    	handlersBotones.add(ataqueHandler);
    	boton.setDisable(true);
    	return boton;
    }
    
    private Button setBotonAtaqueEspecialPersonaje(String text, Personaje personaje, BarrasDeVida barras){
    	Button boton = new Button();
    	boton.setText(text);
    	boton.setMinWidth(this.getPrefWidth());
    	botones.add(boton);
    	BotonAtaqueEspecialHandler ataqueHandler = new BotonAtaqueEspecialHandler(personaje, barras);
    	boton.setOnAction(ataqueHandler);
    	handlersBotones.add(ataqueHandler);
    	boton.setDisable(true);
    	return boton;
    }
    
    private Button setBotonConImagen(String path){
    	Image dir = new Image(path);
    	ImageView botonImagen = new ImageView(dir);
    	Button boton = new Button();
    	boton.setGraphic(botonImagen);
    	return boton;
    }
    
    private void setBotonesDeMovimiento(Equipo equipoMover){
    	Button botonArribaIzquierda = setBotonConImagen("file:src/vista/imagenes/upLeft.png");
    	botones.add(botonArribaIzquierda);
    	BotonMoverArribaIzquierdaHandler moveUpLeftButtonHandler = new BotonMoverArribaIzquierdaHandler(equipoMover, vistaTablero);
        botonArribaIzquierda.setOnAction(moveUpLeftButtonHandler);
        handlersBotones.add(moveUpLeftButtonHandler);
        botonArribaIzquierda.setDisable(true);
        
        Button botonArriba = setBotonConImagen("file:src/vista/imagenes/up.png");
    	botones.add(botonArriba);
    	BotonMoverArribaHandler moveUpButtonHandler = new BotonMoverArribaHandler(equipoMover, vistaTablero);
        botonArriba.setOnAction(moveUpButtonHandler);
        handlersBotones.add(moveUpButtonHandler);
        botonArriba.setDisable(true);
        
        Button botonArribaDerecha = setBotonConImagen("file:src/vista/imagenes/upRight.png");
    	botones.add(botonArribaDerecha);
    	BotonMoverArribaDerechaHandler moveUpRightButtonHandler = new BotonMoverArribaDerechaHandler(equipoMover, vistaTablero);
        botonArribaDerecha.setOnAction(moveUpRightButtonHandler);
        handlersBotones.add(moveUpRightButtonHandler);
        botonArribaDerecha.setDisable(true);
        
        Button botonDerecha = setBotonConImagen("file:src/vista/imagenes/right.png");
    	botones.add(botonDerecha);
    	BotonMoverDerechaHandler moveRightButtonHandler = new BotonMoverDerechaHandler(equipoMover, vistaTablero);
        botonDerecha.setOnAction(moveRightButtonHandler);
        handlersBotones.add(moveRightButtonHandler);
        botonDerecha.setDisable(true);
        
        Button botonAbajoDerecha = setBotonConImagen("file:src/vista/imagenes/downRight.png");
    	botones.add(botonAbajoDerecha);
    	BotonMoverAbajoDerechaHandler moveDownRightButtonHandler = new BotonMoverAbajoDerechaHandler(equipoMover, vistaTablero);
        botonAbajoDerecha.setOnAction(moveDownRightButtonHandler);
        handlersBotones.add(moveDownRightButtonHandler);
        botonAbajoDerecha.setDisable(true);
        
        Button botonAbajo = setBotonConImagen("file:src/vista/imagenes/down.png");
    	botones.add(botonAbajo);
    	BotonMoverAbajoHandler moveDownButtonHandler = new BotonMoverAbajoHandler(equipoMover, vistaTablero);
        botonAbajo.setOnAction(moveDownButtonHandler);
        handlersBotones.add(moveDownButtonHandler);
        botonAbajo.setDisable(true);
        
        Button botonAbajoIzquierda = setBotonConImagen("file:src/vista/imagenes/downLeft.png");
    	botones.add(botonAbajoIzquierda);
    	BotonMoverAbajoIzquierdaHandler moveDownLeftButtonHandler = new BotonMoverAbajoIzquierdaHandler(equipoMover, vistaTablero);
        botonAbajoIzquierda.setOnAction(moveDownLeftButtonHandler);
        handlersBotones.add(moveDownLeftButtonHandler);
        botonAbajoIzquierda.setDisable(true);
        
        Button botonIzquierda = setBotonConImagen("file:src/vista/imagenes/left.png");
    	botones.add(botonIzquierda);
    	BotonMoverIzquierdaHandler moveLeftButtonHandler = new BotonMoverIzquierdaHandler(equipoMover, vistaTablero);
        botonIzquierda.setOnAction(moveLeftButtonHandler);
        handlersBotones.add(moveLeftButtonHandler);
        botonIzquierda.setDisable(true);
    }
    
    private void setBotoneraIzquierda(AlgoBall juego, Equipo agrupacionMover, Equipo agrupacionAtacar,PanelDeCaracteristicas panelCaracteristicas) {
        this.setBotonesDeMovimiento(agrupacionMover);
        Label label = new Label("Seleccionar personaje");
        VBox contenedorVertical = new VBox(label);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        
        for (Personaje personaje : agrupacionMover){
        	ToggleButton tBoton = new ToggleButton(personaje.getNombre());
            tBoton.setToggleGroup(grupo);
            tBoton.setUserData(personaje);
            tBoton.setMinWidth(this.getPrefWidth());
            contenedorVertical.getChildren().add(tBoton);
        }
        
        grupo.selectedToggleProperty().addListener(new ModificadorDePersonaje(grupo,botones, handlersBotones,panelCaracteristicas));
        
        VBox caracteristicas = new VBox();
        caracteristicas.setSpacing(7);
      	caracteristicas.setPadding(new Insets(10));
        panelCaracteristicas.setPanel(caracteristicas);
        
        Button botonTransformar = new Button();
        botonTransformar.setText("Transformar");
        botonTransformar.setDisable(true);
        BotonTransformarEventHandler botonTrasnformarHandler = new BotonTransformarEventHandler(agrupacionMover, vistaTablero);
        botonTransformar.setOnAction(botonTrasnformarHandler);
        botones.add(botonTransformar);
        handlersBotones.add(botonTrasnformarHandler);
        
        //botonTransformar.setToggleGroup(grupo);
        //BotonTransformarEventHandler botonTransformarHandler = new BotonEntrarEventHandler(aplicacion, stage, label1, nombre1, label2, nombre2,reproductor);
        //botonTransformar.setOnAction(botonTransformarHandler);
        
        
        ContenedorFlechas contenedorFlechas = new ContenedorFlechas(botones);
        Label labelBasicos = new Label("Mover personaje");
        contenedorVertical.getChildren().add(labelBasicos);
        contenedorVertical.getChildren().add(contenedorFlechas);
        contenedorVertical.getChildren().add(caracteristicas);
        contenedorVertical.getChildren().add(botonTransformar);
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

        // TODO cambiar por el modelo de Consola...
        Label etiqueta = new Label();
        etiqueta.setText("consola...");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: black;");

        this.setBottom(contenedorConsola);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
    
    public void setProximaEscena(Scene proximaEscena, VistaTablero proximaVista){
    	finalizarTurnoHandler.setProximaEscena(proximaEscena);
    	finalizarTurnoHandler.setProximaVista(proximaVista);
    }
    
    public VistaTablero getVista(){
    	return vistaTablero;
    }
    
    public BarrasDeVida getBarras(){
    	return barras;
    }
    
    public void setProximasBarras(BarrasDeVida proximasBarras){
    	finalizarTurnoHandler.setProximasBarras(proximasBarras);
    }
}
