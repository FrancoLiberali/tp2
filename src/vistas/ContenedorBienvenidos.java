package vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
import javafx.stage.Stage;
import vista.eventos.BotonEntrarEventHandler;

public class ContenedorBienvenidos extends VBox {

    Stage stage;

    public ContenedorBienvenidos(Aplicacion aplicacion, Stage stage) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:src/vista/imagenes/textura.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        
        Label label1 = new Label();
        TextField nombre1 = new TextField();
        nombre1.setPromptText("Ingrese nombre jugador Guerreros Z");
        Label label2 = new Label();
        TextField nombre2 = new TextField();
        nombre2.setPromptText("Ingrese nombre jugador Enemigos de la Tierra");
        
        Button botonEntrar = new Button();
        botonEntrar.setText("Entrar");

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

        etiqueta.setText("Bienvenidos al AlgoBall. Por favor complete los siguientes parametros");
        etiqueta.setTextFill(Color.web("#66A7C5"));

        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(aplicacion, stage, label1, nombre1, label2, nombre2);
        botonEntrar.setOnAction(botonEntrarHandler);
        
        
        this.getChildren().addAll(etiqueta, label1, nombre1, label2, nombre2, botonEntrar);
       
    }
}
