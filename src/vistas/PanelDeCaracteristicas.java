package vistas;

import java.util.ArrayList;

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
	
	
	PanelCaracteristicas panelCaracteristicas;
	ArrayList<String> personajes;
	ArrayList<String> caracteristicas;
	ArrayList<String> caracteristicasTranformacion;
	Button botonTransformar;
	
	public PanelDeCaracteristicas(PanelCaracteristicas panelCaracteristicas){
		
		this.panelCaracteristicas = panelCaracteristicas;
		this.personajes = panelCaracteristicas.Personajes();
		this.caracteristicas = panelCaracteristicas.caracteristicas();
		this.caracteristicasTranformacion = panelCaracteristicas.caracteristicasTransformacion();
		
		this.setSpacing(7); 
		this.setPadding(new Insets(10));
		}
		public void agregarPanelCaracteristicas(Personaje personaje){
			
			
			this.getChildren().clear();
			
			VBox vb = new VBox();
			HBox hB = new HBox();
			
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
			 Image imagen = new Image(personaje.getImagen() );
		     ImageView imagenPersonaje = new ImageView(imagen);
		     imagenPersonaje.setFitWidth(200);
		     imagenPersonaje.setPreserveRatio(true);
		     hB.getChildren().addAll(imagenPersonaje,vb);
		     this.getChildren().addAll(hB,botonTransformar);
			
		}
		public void agregarBotonTransformar(Button botonTransformar){
			this.botonTransformar = botonTransformar;
			
		}
		
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
		
		
		
		
}

	
