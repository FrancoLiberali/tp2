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

public class CajaInformacionProximaTransformacion extends VBox{
	private Personaje personaje;
	private Hashtable<String, Integer> caracteristicas = new Hashtable<String, Integer>();
	private Label nombrePersonaje = new Label();
	private PanelDeCaracteristicas panelCaracteristicas;
	private ImageView contenedorImagen;
	
	
	public CajaInformacionProximaTransformacion(){
		this.setSpacing(2);
		this.getChildren().add(nombrePersonaje);
		this.setAlignment(Pos.CENTER);
		HBox hb = new HBox();
		contenedorImagen = new ImageView();
		hb.getChildren().add(contenedorImagen);
		this.panelCaracteristicas = new PanelDeCaracteristicas(caracteristicas);
		hb.getChildren().add(panelCaracteristicas);
		this.getChildren().add(hb);
		this.setDisable(true);
		
	}	
	
	public void setNombrePersonaje(){
		this.nombrePersonaje = new Label(personaje.getNombre() + " " + personaje.getEstado().getEstadoSiguiente().getNombre());		
		nombrePersonaje.setFont(Font.font("courier new", FontWeight.BOLD, 14));
	}
	public void actualizar(Personaje personaje){
		this.personaje = personaje;
		this.getChildren().remove(nombrePersonaje);
		this.setNombrePersonaje();
		this.getChildren().add(0, nombrePersonaje);
		contenedorImagen.setImage(new Image(personaje.getEstado().getEstadoSiguiente().getImagen(),30,50,false,true));
		this.caracteristicas = this.personaje.darCaracteristicasTransformacion();
		this.panelCaracteristicas.actualizar(caracteristicas);
		this.setDisable(false);
	}
}
