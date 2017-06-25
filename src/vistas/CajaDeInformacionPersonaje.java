package vistas;

import java.util.Hashtable;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.personajes.Personaje;

public class CajaDeInformacionPersonaje extends VBox{
	
	private Personaje personaje;
	private Hashtable<String, Integer> caracteristicas;
	private Label nombrePersonaje ; 
	private BarraDeVida barraDeVida; 
	private PanelDeCaracteristicas panelCaracteristicas;
	private ImageView contenedorImagen;
	
	
	public CajaDeInformacionPersonaje(Personaje personaje){
		this.personaje = personaje;
		this.caracteristicas = personaje.darCaracteriticas();
		this.setNombrePersonaje();
		this.getChildren().add(nombrePersonaje);
		this.setAlignment(Pos.CENTER);
		this.barraDeVida = new BarraDeVida(personaje);
		this.getChildren().add(barraDeVida );
		HBox hb = new HBox();
		contenedorImagen = new ImageView();
		contenedorImagen.setFitWidth(50);
		contenedorImagen.setPreserveRatio(true);
		contenedorImagen.setSmooth(true);
        contenedorImagen.setImage(new Image(personaje.getImagen()));
		hb.getChildren().add(contenedorImagen);
		this.panelCaracteristicas = new PanelDeCaracteristicas(caracteristicas);
		hb.getChildren().add(panelCaracteristicas);
		this.getChildren().add(hb);
		
	}	
	
	public void setNombrePersonaje(){
		this.nombrePersonaje = new Label(personaje.getNombre() + " " + personaje.getEstado().getNombre());		
		nombrePersonaje.setFont(Font.font("courier new", FontWeight.BOLD, 16));
	}
	public void actualizar(){
		this.setNombrePersonaje();
		contenedorImagen.setImage(new Image(personaje.getImagen()));
		this.barraDeVida.actualizar();
		this.caracteristicas = this.personaje.darCaracteriticas();
		this.panelCaracteristicas.actualizar(caracteristicas);
	}
}
