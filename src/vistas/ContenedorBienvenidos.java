package vistas;


import controladores.eventos.BotonEntrarEventHandler;
import controladores.eventos.MuteOnOffEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class ContenedorBienvenidos extends VBox {

    Stage stage;
    Reproductor reproductor;
    private Button botonEntrar;
    
    public ContenedorBienvenidos(Aplicacion aplicacion, Stage stage, Screen screen ,Reproductor reproductor) {

        super();

        this.stage = stage;
        this.reproductor = reproductor;
        
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:src/vista/imagenes/pantallaInicio.jpg",Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight() +50, false, true);
        
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        
        // falta poner el tamanioo correcto
        ToggleButton botonMudo = new ToggleButton();
        Image imagen1 = new Image("file:src/vistas/imagenes/sonidoOn.png" );
        ImageView imagenBoton = new ImageView(imagen1);
        imagenBoton.setFitWidth(50);
        imagenBoton.setPreserveRatio(true);
        imagenBoton.setSmooth(true);
        botonMudo.setGraphic(imagenBoton);
        botonMudo.setStyle("-fx-background-color:transparent;");
        botonMudo.setAlignment(Pos.TOP_RIGHT );//no esta funcionando 
        botonMudo.setOnAction(new MuteOnOffEventHandler(botonMudo, reproductor));
       
        
        
        Label label1 = new Label();
        TextField nombre1 = new TextField();
        nombre1.setPromptText("Ingrese nombre jugador Guerreros Z");
    

        Label label2 = new Label();
        TextField nombre2 = new TextField();
        nombre2.setPromptText("Ingrese nombre jugador Enemigos de la Tierra");
        
        botonEntrar = new Button();
        Image imagenInicio = new Image("file:src/vista/imagenes/inicio.gif" );
        ImageView imagenBotonEntrar = new ImageView(imagenInicio);
        imagenBotonEntrar.setFitWidth(125);
        imagenBotonEntrar.setPreserveRatio(true);
        imagenBotonEntrar.setSmooth(true);
        botonEntrar.setGraphic(imagenBotonEntrar);
        botonEntrar.setStyle("-fx-background-color:transparent;");
        //botonEntrar.setAlignment(Pos.TOP_RIGHT );//no esta funcionando 
        //botonEntrar.setText("Entrar");

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 22));

        etiqueta.setText("Bienvenidos al AlgoBall. Por favor complete los siguientes parametros");
        etiqueta.setTextFill(Color.RED);

        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(aplicacion, stage, label1, nombre1, label2, nombre2,reproductor);
        botonEntrar.setOnAction(botonEntrarHandler);
        
        
        this.getChildren().addAll(botonMudo,etiqueta, label1, nombre1, label2, nombre2, botonEntrar);
       
    }
    
    public Button getBotonEntrar(){
    	return botonEntrar;
    }
}
