package vistas;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import controladores.eventos.BotonAtaqueBasicoHandler;
import controladores.eventos.BotonAtaqueEspecialHandler;
import controladores.eventos.BotonFinalizarTurnoHandler;
import controladores.eventos.BotonModificableHandler;
import controladores.eventos.BotonTransformarEventHandler;
import controladores.eventos.ModificadorDePersonaje;
import controladores.eventos.botonMoverHandlers.BotonMoverAbajoDerechaHandler;
import controladores.eventos.botonMoverHandlers.BotonMoverAbajoHandler;
import controladores.eventos.botonMoverHandlers.BotonMoverAbajoIzquierdaHandler;
import controladores.eventos.botonMoverHandlers.BotonMoverArribaDerechaHandler;
import controladores.eventos.botonMoverHandlers.BotonMoverArribaHandler;
import controladores.eventos.botonMoverHandlers.BotonMoverArribaIzquierdaHandler;
import controladores.eventos.botonMoverHandlers.BotonMoverDerechaHandler;
import controladores.eventos.botonMoverHandlers.BotonMoverIzquierdaHandler;
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
import javafx.stage.Stage;
import model.algoBall.AlgoBall;
import model.algoBall.Equipo;
import model.personajes.Personaje;

public class ContenedorPrincipal extends BorderPane {
	
	List<Button> botones = new ArrayList<Button>();
    List<BotonModificableHandler> handlersBotones = new ArrayList<BotonModificableHandler>();
    BarraDeMenu menuBar;
	private BotonFinalizarTurnoHandler finalizarTurnoHandler;
	final ToggleGroup grupo = new ToggleGroup();
	private Canvas canvasCentral;
	private VistaTablero vistaTablero;
	private Consola consola;
	private Hashtable<String,CajaDeInformacionPersonaje> cajas;
    

    public ContenedorPrincipal(Stage stage, AlgoBall juego, Equipo equipoMover, Equipo equipoAtacar,Reproductor reproductor) {
        this.setPrefWidth(75);
    	this.setMenu(stage, reproductor);
        this.setConsola();
        this.setCentro(juego, equipoMover, equipoAtacar);
        this.setBotoneraDerecha(stage, juego, equipoAtacar, equipoMover);
        this.setBotoneraIzquierda(stage, juego, equipoMover, equipoAtacar);
        
        
    }
    
    private void setBotoneraDerecha(Stage stage, AlgoBall juego, Equipo equipoAtacar, Equipo equipoMover) {
    	
    	VBox contenedorVertical = new VBox();
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        
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
        
        /*barras = new BarrasDeVida(equipoAtacar, equipoMover);
        contenedorVertical.getChildren().add(barras);
        
        Button botonTransformar = new Button();
        botonTransformar.setText("Transformar");
        botonTransformar.setDisable(true);
        BotonTransformarEventHandler botonTransformarHandler = new BotonTransformarEventHandler(equipoMover, vistaTablero, this.consola);
        botonTransformar.setOnAction(botonTransformarHandler);
        botones.add(botonTransformar);
        handlersBotones.add(botonTransformarHandler);
        panelCaracteristicas.agregarBotonTransformar(botonTransformar);
        contenedorVertical.getChildren().add(panelCaracteristicas);*/
        
        this.setRight(contenedorVertical);

    }
    private Button setBotonAtaqueBasicoPersonaje(String text, Personaje personaje){
    	Button boton = new Button();
    	boton.setText(text);
    	boton.setMinWidth(this.getPrefWidth());
    	botones.add(boton);
    	BotonAtaqueBasicoHandler ataqueHandler = new BotonAtaqueBasicoHandler(personaje, cajas, consola);
    	boton.setOnAction(ataqueHandler);
    	handlersBotones.add(ataqueHandler);
    	boton.setDisable(true);
    	return boton;
    }
    
    private Button setBotonAtaqueEspecialPersonaje(String text, Personaje personaje){
    	Button boton = new Button();
    	boton.setText(text);
    	boton.setMinWidth(this.getPrefWidth());
    	botones.add(boton);
    	BotonAtaqueEspecialHandler ataqueHandler = new BotonAtaqueEspecialHandler(personaje, cajas, consola);
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
    	Button botonArribaIzquierda = setBotonConImagen("file:src/vistas/imagenes/upLeft.png");
    	botones.add(botonArribaIzquierda);
    	BotonMoverArribaIzquierdaHandler moveUpLeftButtonHandler = new BotonMoverArribaIzquierdaHandler(equipoMover, vistaTablero, this.consola);
        botonArribaIzquierda.setOnAction(moveUpLeftButtonHandler);
        handlersBotones.add(moveUpLeftButtonHandler);
        botonArribaIzquierda.setDisable(true);
        
        Button botonArriba = setBotonConImagen("file:src/vistas/imagenes/up.png");
    	botones.add(botonArriba);
    	BotonMoverArribaHandler moveUpButtonHandler = new BotonMoverArribaHandler(equipoMover, vistaTablero, this.consola);
        botonArriba.setOnAction(moveUpButtonHandler);
        handlersBotones.add(moveUpButtonHandler);
        botonArriba.setDisable(true);
        
        Button botonArribaDerecha = setBotonConImagen("file:src/vistas/imagenes/upRight.png");
    	botones.add(botonArribaDerecha);
    	BotonMoverArribaDerechaHandler moveUpRightButtonHandler = new BotonMoverArribaDerechaHandler(equipoMover, vistaTablero, this.consola);
        botonArribaDerecha.setOnAction(moveUpRightButtonHandler);
        handlersBotones.add(moveUpRightButtonHandler);
        botonArribaDerecha.setDisable(true);
        
        Button botonDerecha = setBotonConImagen("file:src/vistas/imagenes/right.png");
    	botones.add(botonDerecha);
    	BotonMoverDerechaHandler moveRightButtonHandler = new BotonMoverDerechaHandler(equipoMover, vistaTablero, this.consola);
        botonDerecha.setOnAction(moveRightButtonHandler);
        handlersBotones.add(moveRightButtonHandler);
        botonDerecha.setDisable(true);
        
        Button botonIzquierda = setBotonConImagen("file:src/vistas/imagenes/left.png");
    	botones.add(botonIzquierda);
    	BotonMoverIzquierdaHandler moveLeftButtonHandler = new BotonMoverIzquierdaHandler(equipoMover, vistaTablero, this.consola);
        botonIzquierda.setOnAction(moveLeftButtonHandler);
        handlersBotones.add(moveLeftButtonHandler);
        botonIzquierda.setDisable(true);
        
        Button botonAbajoIzquierda = setBotonConImagen("file:src/vistas/imagenes/downLeft.png");
    	botones.add(botonAbajoIzquierda);
    	BotonMoverAbajoIzquierdaHandler moveDownLeftButtonHandler = new BotonMoverAbajoIzquierdaHandler(equipoMover, vistaTablero, this.consola);
        botonAbajoIzquierda.setOnAction(moveDownLeftButtonHandler);
        handlersBotones.add(moveDownLeftButtonHandler);
        botonAbajoIzquierda.setDisable(true);
        
        Button botonAbajo = setBotonConImagen("file:src/vistas/imagenes/down.png");
    	botones.add(botonAbajo);
    	BotonMoverAbajoHandler moveDownButtonHandler = new BotonMoverAbajoHandler(equipoMover, vistaTablero, this.consola);
        botonAbajo.setOnAction(moveDownButtonHandler);
        handlersBotones.add(moveDownButtonHandler);
        botonAbajo.setDisable(true);
        
        Button botonAbajoDerecha = setBotonConImagen("file:src/vistas/imagenes/downRight.png");
    	botones.add(botonAbajoDerecha);
    	BotonMoverAbajoDerechaHandler moveDownRightButtonHandler = new BotonMoverAbajoDerechaHandler(equipoMover, vistaTablero, this.consola);
        botonAbajoDerecha.setOnAction(moveDownRightButtonHandler);
        handlersBotones.add(moveDownRightButtonHandler);
        botonAbajoDerecha.setDisable(true);
    }
    
    private void setBotoneraIzquierda(Stage stage, AlgoBall juego, Equipo equipoMover, Equipo equipoAtacar) {
    	
    	VBox contenedorVertical = new VBox();
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        
    	Label nombreDeEquipo = new Label (equipoMover.getNombre());
    	Label label = new Label("Seleccionar personaje");
        contenedorVertical.getChildren().add(nombreDeEquipo);
        contenedorVertical.getChildren().add(label);
        
        for (Personaje personaje : equipoMover){
        	ToggleButton tBoton = new ToggleButton(personaje.getNombre());
            tBoton.setToggleGroup(grupo);
            tBoton.setUserData(personaje);
            tBoton.setMinWidth(this.getPrefWidth());
            contenedorVertical.getChildren().add(tBoton);
        }
        
        grupo.selectedToggleProperty().addListener(new ModificadorDePersonaje(grupo,botones, handlersBotones));
        
        this.setBotonesDeMovimiento(equipoMover);
        ContenedorFlechas contenedorFlechas = new ContenedorFlechas(botones);
        Label labelMover = new Label("Mover personaje");
        contenedorVertical.getChildren().add(labelMover);
        contenedorVertical.getChildren().add(contenedorFlechas);
        
        Label labelBasicos = new Label("Realizar ataque basico sobre:");
        contenedorVertical.getChildren().add(labelBasicos);
        for (Personaje personaje : equipoAtacar){
        	Button boton = this.setBotonAtaqueBasicoPersonaje(personaje.getNombre(), personaje);
        	contenedorVertical.getChildren().add(boton);
        }
        Label labelEspecial = new Label("Realizar ataque especial sobre:");
        contenedorVertical.getChildren().add(labelEspecial);
        for (Personaje personaje : equipoAtacar){
        	Button boton = this.setBotonAtaqueEspecialPersonaje(personaje.getNombre(), personaje);
        	contenedorVertical.getChildren().add(boton);
        }
        
        
        Button botonTransformar = new Button();
        botonTransformar.setText("Transformar");
        botonTransformar.setDisable(true);
        BotonTransformarEventHandler botonTransformarHandler = new BotonTransformarEventHandler(equipoMover, vistaTablero, this.consola, cajas);
        botonTransformar.setOnAction(botonTransformarHandler);
        botones.add(botonTransformar);
        handlersBotones.add(botonTransformarHandler);
        contenedorVertical.getChildren().add(botonTransformar);
        
        
        Button finalizarTurno = new Button();
        finalizarTurno.setText("Finalizar turno");
        BotonFinalizarTurnoHandler finalizarHandler = new BotonFinalizarTurnoHandler(stage, juego, this.consola);
        this.finalizarTurnoHandler = finalizarHandler;
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
    
    public void setProximaEscena(Scene proximaEscena, VistaTablero proximaVista){
    	finalizarTurnoHandler.setProximaEscena(proximaEscena);
    	finalizarTurnoHandler.setProximaVista(proximaVista);
    }
    
    public VistaTablero getVista(){
    	return vistaTablero;
    }
    
    public void setProximasBarras(BarrasDeVida proximasBarras){
    	finalizarTurnoHandler.setProximasBarras(proximasBarras);
    }
}
