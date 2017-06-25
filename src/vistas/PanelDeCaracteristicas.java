package vistas;

import java.util.ArrayList;
import java.util.Hashtable;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.personajes.Personaje;
import model.personajes.elementos.PanelCaracteristicas;


public class PanelDeCaracteristicas extends VBox {
	
	Hashtable<String, Integer> caracteristicas;
	
	public PanelDeCaracteristicas(Hashtable<String, Integer> caracteristicas){
		
		this.caracteristicas = caracteristicas;
		this.setSpacing(7); 
		this.setPadding(new Insets(10));
		this.setCaracteristicas();
		
	}
	
	public void setCaracteristicas(){
		
		for (String caracteristica : caracteristicas.keySet()){
			
			Label caracteristicaDePersonaje = new Label();
			caracteristicaDePersonaje.setText(caracteristica + ":");
			caracteristicaDePersonaje.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
			Label valor = new Label();
			valor.setText(caracteristicas.get(caracteristica).toString());
			valor.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
			final HBox hb = new HBox();
			hb.setAlignment(Pos.CENTER_RIGHT);
			hb.getChildren().addAll(caracteristicaDePersonaje, valor);
			this.getChildren().add(hb);
			}
		
	}
	
	
	public void actualizar(Hashtable<String, Integer> nuevasCaracteristicas){
		
		this.getChildren().clear();
		this.caracteristicas = nuevasCaracteristicas;
		this.setCaracteristicas();
		
		
		
	}
		
		/*
		public void setearBotonTransformar(Personaje personaje){
			VBox vb = new VBox();
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
				vb.getChildren().add(hb);
				}
		     this.getChildren().addAll(vb);	
		}
		
		*/
		
		
}

	
