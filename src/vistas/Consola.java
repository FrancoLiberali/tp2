package vistas;

import javafx.util.Duration;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Consola extends VBox
{
	private Label nombre = new Label();
	private Label ioStream = new Label();
	
	public Consola(){
		nombre.setText("consola...");
		nombre.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
		nombre.setTextFill(Color.WHITE);

		this.setSpacing(10);
		this.setPadding(new Insets(15));
		this.setStyle("-fx-background-color: black;");
		this.getChildren().add(nombre);
	}
	
	public void agregarInformacion(String mensajeTemporal){
		this.getChildren().clear();
		this.setMensajeTemporal(mensajeTemporal);
		this.limpiarMensajeTemporal();
	}
	
	public void reiniciar(){
		this.getChildren().clear();
		this.getChildren().add(this.nombre);
	}
	
	private void limpiarMensajeTemporal()
	{
		PauseTransition pause = new PauseTransition(Duration.seconds(3));
		pause.setOnFinished(event -> ioStream.setText(""));
		pause.play();
	}
	
	private void setMensajeTemporal(String mensaje)
	{
		ioStream.setText(mensaje);
		ioStream.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
		ioStream.setTextFill(Color.WHITE);
		this.getChildren().add(ioStream);
	}
}