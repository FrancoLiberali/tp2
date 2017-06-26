package vistas;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import controladores.eventos.BotonAtaqueBasicoHandler;
import controladores.eventos.BotonAtaqueEspecialHandler;
import controladores.eventos.BotonAtaqueHandler;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.algoBall.AlgoBall;
import model.algoBall.Equipo;
import model.personajes.Personaje;

public class BotoneraIzquierda extends VBox{
	
	private List<Button> botones = new ArrayList<Button>();
    private List<BotonModificableHandler> handlersBotones = new ArrayList<BotonModificableHandler>();
    private final ToggleGroup grupo = new ToggleGroup();
    private VistaTablero vistaTablero;
    private Consola consola;
    private Hashtable<String,CajaDeInformacionPersonaje> cajas;
    private BotoneraIzquierda botoneraSiguiente;
    private List<ToggleButton> botonesPersonajes = new ArrayList<ToggleButton>();
    private Equipo equipoMover;
    private Equipo equipoAtacar;
    private Hashtable<Button, BotonAtaqueHandler> botonesAtacar = new Hashtable<Button, BotonAtaqueHandler>();
    private AlgoBall juego;
    
	public BotoneraIzquierda(AlgoBall juego, Equipo equipoMover, Equipo equipoAtacar,VistaTablero vistaTablero, Consola consola, Hashtable<String,CajaDeInformacionPersonaje> cajas){
		this.setSpacing(10);
	    this.setPrefWidth(75);
	    this.juego = juego;
		this.vistaTablero = vistaTablero;
		this.consola = consola;
		this.cajas = cajas;
		this.equipoMover = equipoMover;
		this.equipoAtacar = equipoAtacar;
		Label nombreDeEquipo = new Label (equipoMover.getNombre());
    	Label label = new Label("Seleccionar personaje");
        this.getChildren().add(nombreDeEquipo);
        this.getChildren().add(label);
        
        for (Personaje personaje : equipoMover){
        	ToggleButton tBoton = new ToggleButton(personaje.getNombre());
            tBoton.setToggleGroup(grupo);
            tBoton.setUserData(personaje);
            tBoton.setMinWidth(this.getPrefWidth());
            botonesPersonajes.add(tBoton);
            this.getChildren().add(tBoton);
        }
        
        grupo.selectedToggleProperty().addListener(new ModificadorDePersonaje(grupo,botones, handlersBotones));
        
        this.setBotonesDeMovimiento(equipoMover);
        ContenedorFlechas contenedorFlechas = new ContenedorFlechas(botones);
        Label labelMover = new Label("Mover personaje");
        this.getChildren().add(labelMover);
        this.getChildren().add(contenedorFlechas);
        
        Label labelBasicos = new Label("Realizar ataque basico sobre:");
        this.getChildren().add(labelBasicos);
        for (Personaje personaje : equipoAtacar){
        	Button boton = this.setBotonAtaqueBasicoPersonaje(personaje.getNombre(), personaje);
        	this.getChildren().add(boton);
        }
        Label labelEspecial = new Label("Realizar ataque especial sobre:");
        this.getChildren().add(labelEspecial);
        for (Personaje personaje : equipoAtacar){
        	Button boton = this.setBotonAtaqueEspecialPersonaje(personaje.getNombre(), personaje);
        	this.getChildren().add(boton);
        }
        
        
        Button botonTransformar = new Button();
        botonTransformar.setText("Transformar");
        botonTransformar.setDisable(true);
        BotonTransformarEventHandler botonTransformarHandler = new BotonTransformarEventHandler(equipoMover, vistaTablero, consola, cajas);
        botonTransformar.setOnAction(botonTransformarHandler);
        botones.add(botonTransformar);
        handlersBotones.add(botonTransformarHandler);
        this.getChildren().add(botonTransformar);
	}
	
	public void setSiguiente(BotoneraIzquierda siguiente){
		this.botoneraSiguiente = siguiente;
	}
	
	public BotoneraIzquierda getSiguiente(){
		return botoneraSiguiente;
	}
	
	public void actualizar(){
		for (ToggleButton boton : botonesPersonajes){
			if (!equipoMover.perteneceMismaAgrupacion((Personaje)boton.getUserData())){
				this.getChildren().remove(boton);
			}
		}
		for (Button boton : botonesAtacar.keySet()){
			if (!equipoAtacar.perteneceMismaAgrupacion(botonesAtacar.get(boton).getPersonaje())){
				this.getChildren().remove(boton);
			}
		}
		for (CajaDeInformacionPersonaje caja: cajas.values()){
			caja.actualizar();
		}
		
	}
	
	private Button setBotonAtaqueBasicoPersonaje(String text, Personaje personaje){
    	Button boton = new Button();
    	boton.setText(text);
    	boton.setMinWidth(this.getPrefWidth());
    	botones.add(boton);
    	BotonAtaqueBasicoHandler ataqueHandler = new BotonAtaqueBasicoHandler(juego, personaje, cajas, consola);
    	boton.setOnAction(ataqueHandler);
    	handlersBotones.add(ataqueHandler);
    	boton.setDisable(true);
    	botonesAtacar.put(boton, ataqueHandler);
    	return boton;
    }
    
    private Button setBotonAtaqueEspecialPersonaje(String text, Personaje personaje){
    	Button boton = new Button();
    	boton.setText(text);
    	boton.setMinWidth(this.getPrefWidth());
    	botones.add(boton);
    	BotonAtaqueEspecialHandler ataqueHandler = new BotonAtaqueEspecialHandler(juego, personaje, cajas, consola);
    	boton.setOnAction(ataqueHandler);
    	handlersBotones.add(ataqueHandler);
    	boton.setDisable(true);
    	botonesAtacar.put(boton, ataqueHandler);
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
    	BotonMoverArribaIzquierdaHandler moveUpLeftButtonHandler = new BotonMoverArribaIzquierdaHandler(equipoMover, vistaTablero, consola, cajas);
        botonArribaIzquierda.setOnAction(moveUpLeftButtonHandler);
        handlersBotones.add(moveUpLeftButtonHandler);
        botonArribaIzquierda.setDisable(true);
        
        Button botonArriba = setBotonConImagen("file:src/vistas/imagenes/up.png");
    	botones.add(botonArriba);
    	BotonMoverArribaHandler moveUpButtonHandler = new BotonMoverArribaHandler(equipoMover, vistaTablero, consola, cajas);
        botonArriba.setOnAction(moveUpButtonHandler);
        handlersBotones.add(moveUpButtonHandler);
        botonArriba.setDisable(true);
        
        Button botonArribaDerecha = setBotonConImagen("file:src/vistas/imagenes/upRight.png");
    	botones.add(botonArribaDerecha);
    	BotonMoverArribaDerechaHandler moveUpRightButtonHandler = new BotonMoverArribaDerechaHandler(equipoMover, vistaTablero, consola, cajas);
        botonArribaDerecha.setOnAction(moveUpRightButtonHandler);
        handlersBotones.add(moveUpRightButtonHandler);
        botonArribaDerecha.setDisable(true);
        
        Button botonDerecha = setBotonConImagen("file:src/vistas/imagenes/right.png");
    	botones.add(botonDerecha);
    	BotonMoverDerechaHandler moveRightButtonHandler = new BotonMoverDerechaHandler(equipoMover, vistaTablero, consola, cajas);
        botonDerecha.setOnAction(moveRightButtonHandler);
        handlersBotones.add(moveRightButtonHandler);
        botonDerecha.setDisable(true);
        
        Button botonIzquierda = setBotonConImagen("file:src/vistas/imagenes/left.png");
    	botones.add(botonIzquierda);
    	BotonMoverIzquierdaHandler moveLeftButtonHandler = new BotonMoverIzquierdaHandler(equipoMover, vistaTablero, consola, cajas);
        botonIzquierda.setOnAction(moveLeftButtonHandler);
        handlersBotones.add(moveLeftButtonHandler);
        botonIzquierda.setDisable(true);
        
        Button botonAbajoIzquierda = setBotonConImagen("file:src/vistas/imagenes/downLeft.png");
    	botones.add(botonAbajoIzquierda);
    	BotonMoverAbajoIzquierdaHandler moveDownLeftButtonHandler = new BotonMoverAbajoIzquierdaHandler(equipoMover, vistaTablero, consola, cajas);
        botonAbajoIzquierda.setOnAction(moveDownLeftButtonHandler);
        handlersBotones.add(moveDownLeftButtonHandler);
        botonAbajoIzquierda.setDisable(true);
        
        Button botonAbajo = setBotonConImagen("file:src/vistas/imagenes/down.png");
    	botones.add(botonAbajo);
    	BotonMoverAbajoHandler moveDownButtonHandler = new BotonMoverAbajoHandler(equipoMover, vistaTablero, consola, cajas);
        botonAbajo.setOnAction(moveDownButtonHandler);
        handlersBotones.add(moveDownButtonHandler);
        botonAbajo.setDisable(true);
        
        Button botonAbajoDerecha = setBotonConImagen("file:src/vistas/imagenes/downRight.png");
    	botones.add(botonAbajoDerecha);
    	BotonMoverAbajoDerechaHandler moveDownRightButtonHandler = new BotonMoverAbajoDerechaHandler(equipoMover, vistaTablero, consola, cajas);
        botonAbajoDerecha.setOnAction(moveDownRightButtonHandler);
        handlersBotones.add(moveDownRightButtonHandler);
        botonAbajoDerecha.setDisable(true);
    }

}
