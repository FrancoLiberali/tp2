package vistas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.personajes.Personaje;

public class BarraDeVida extends HBox {
	Personaje personaje;
	
	public BarraDeVida(Personaje personaje){
		this.setAlignment(Pos.CENTER_RIGHT);
		this.personaje = personaje;
		this.setBarraVida();
	}
	
	public void setBarraVida(){
		Label numeroVida = new Label();
		numeroVida.setText(((Integer)personaje.getSalud()).toString());
		numeroVida.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
		ProgressBar barraVidaParticular = new ProgressBar(); // crea la barra de vida
		barraVidaParticular.setProgress(personaje.getPorcentajeSalud()/100F); // Ese F es necesario
		this.getChildren().addAll(barraVidaParticular, numeroVida);
	}
	public void actualizar(){
		this.getChildren().clear();
		this.setBarraVida();
	}
	
}
