package vistas;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LabelModificable extends Label{
	
	public LabelModificable(){
		super();
		this.setFont(Font.font("courier new", FontWeight.BOLD, 10));
		this.setDisable(true);
	}
	
	public void modificar(String text, Integer valor){
		this.setDisable(false);
		this.setText(text + ": " + valor.toString());
	}
}
