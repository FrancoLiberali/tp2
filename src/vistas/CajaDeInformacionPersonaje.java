package vistas;

import java.util.Hashtable;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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
	PanelDeCaracteristicas panelCaracteristicas;
	
	
	public CajaDeInformacionPersonaje(Personaje personaje){
		this.personaje = personaje;
		this.caracteristicas = personaje.darCaracteriticas();
		this.setNombrePersonaje();
		this.getChildren().add(nombrePersonaje);
		this.barraDeVida = new BarraDeVida(personaje);
		this.getChildren().add(barraDeVida );
		this.panelCaracteristicas = new PanelDeCaracteristicas(caracteristicas); 
		this.getChildren().add(panelCaracteristicas);
		
	}	
	
	public void setNombrePersonaje(){
		this.nombrePersonaje = new Label(personaje.getNombre() + " " + personaje.getEstado().getNombre());
		
	}
	public void actualizar(){
		this.setNombrePersonaje();
		this.barraDeVida.actualizar();
		this.caracteristicas = this.personaje.darCaracteriticas();
		this.panelCaracteristicas.actualizar(caracteristicas);
	}
}
