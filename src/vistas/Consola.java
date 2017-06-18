package vistas;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Consola extends VBox{
	
	
	public Consola(){
		Label etiqueta = new Label();
	    etiqueta.setText("consola...");
	    etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
	    etiqueta.setTextFill(Color.WHITE);
	    this.setSpacing(10);
	    this.setPadding(new Insets(15));
	    this.setStyle("-fx-background-color: black;");
	    this.getChildren().add(etiqueta);

	   

	}
	
    public void agregarInformacion(String stg){
    	Label frase = new Label();
    	frase.setText("consola...");
	    frase.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
	    frase.setTextFill(Color.WHITE);
    	this.getChildren().add(frase);
    }

    
}
