package vistas;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import algoBall.Equipo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import personajes.Personaje;

public class BarrasDeVida extends VBox{
	List<Equipo> equipos = new ArrayList<Equipo>();
	Hashtable<Personaje,ProgressBar> barras = new Hashtable<Personaje,ProgressBar>();
	
	public BarrasDeVida(Equipo equipo1, Equipo equipo2){
		equipos.add(equipo1);
		equipos.add(equipo2);
		this.setSpacing(7); //no se si estara bien
		this.setPadding(new Insets(10));
		this.agregarBarras();
	}
	public void agregarBarras(){
		for (Equipo equipo : equipos){
			for (Personaje personaje : equipo){
	
				Label nombrePersonaje = new Label();
				nombrePersonaje.setText(personaje.getNombre() + ":");
				nombrePersonaje.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
	
				ProgressBar barraVidaParticular = new ProgressBar(); // crea la barra de vida
				barras.put(personaje, barraVidaParticular);
				barraVidaParticular.setProgress(personaje.getPorcentajeSalud()/100F); // Ese F es necesario
	
				final HBox hb = new HBox();
				hb.setAlignment(Pos.CENTER_RIGHT);
				hb.getChildren().addAll(nombrePersonaje, barraVidaParticular);
				this.getChildren().add(hb);
			}
		}
	}
	
	public void actualizar(){
		for (Personaje personaje : barras.keySet()){
			barras.get(personaje).setProgress(personaje.getPorcentajeSalud()/100F);
		}
	}
}
