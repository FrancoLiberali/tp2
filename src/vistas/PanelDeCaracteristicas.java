package vistas;

import java.util.ArrayList;

import funcionamientoPersonaje.elementos.PanelCaracteristicas;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import personajes.Personaje;


public class PanelDeCaracteristicas {
	
	
	PanelCaracteristicas panelCaracteristicas;
	ArrayList<String> personajes;
	ArrayList<String> caracteristicas;
	VBox panel;
	
	public PanelDeCaracteristicas(PanelCaracteristicas panelCaracteristicas){
		
		this.panelCaracteristicas = panelCaracteristicas;
		this.personajes = panelCaracteristicas.Personajes();
		this.caracteristicas = panelCaracteristicas.caracteristicas();
		//this.setSpacing(7); -
		//this.setPadding(new Insets(10));
		}
		public Void agregarPanelCaracteristicas(Personaje personaje){
			
			
			panel.getChildren().clear();
			for (String caracteristica : this.caracteristicas){
				
				Label caracteristicaDePersonaje = new Label();
				caracteristicaDePersonaje.setText(caracteristica + ":");
				caracteristicaDePersonaje.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
				Label valor = new Label();
				//this.panelCaracteristicas.mostrarCaracteristica(personaje.getNombre(), caracteristica)
				valor.setText(((Integer)this.panelCaracteristicas.mostrarCaracteristica(personaje.getNombre(), caracteristica)).toString());
				valor.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
				final HBox hb = new HBox();
				hb.setAlignment(Pos.CENTER_RIGHT);
				hb.getChildren().addAll(caracteristicaDePersonaje, valor);
				panel.getChildren().add(hb);
				}
			return null;
			
		}
		
		public void setPanel(VBox vbox){
			this.panel = vbox;
		}
}

	
