package vistas;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Consola extends VBox{
	private Label nombre = new Label();
	
	public Consola(){
		
		nombre.setText("consola...");
		nombre.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
		nombre.setTextFill(Color.WHITE);

		
		this.setSpacing(10);
		this.setPadding(new Insets(15));
		this.setStyle("-fx-background-color: black;");
		
		this.getChildren().add(nombre);
		
	}
	public void agregarInformacion(String stg){
		this.getChildren().clear();
		Label ioStream = new Label();
		ioStream.setText(stg);
		ioStream.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
		ioStream.setTextFill(Color.WHITE);
		this.getChildren().add(ioStream);
	}
	public void reiniciar(){
		this.getChildren().clear();
		this.getChildren().add(this.nombre);
		
	}
}