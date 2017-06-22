package vistas;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.algoBall.Equipo;
import model.personajes.Personaje;

public class BarrasDeVida extends VBox{
	List<Equipo> equipos = new ArrayList<Equipo>();
	Hashtable<Personaje,ProgressBar> barras = new Hashtable<Personaje,ProgressBar>();
	Hashtable<Personaje,Label> numerosVida = new Hashtable<Personaje, Label>();
	
	public BarrasDeVida(Equipo equipo1, Equipo equipo2){
		equipos.add(equipo1);
		equipos.add(equipo2);
		this.setSpacing(7); 
		this.setPadding(new Insets(10));
		this.agregarBarras();
	}
	public void agregarBarras(){
		for (Equipo equipo : equipos){
			for (Personaje personaje : equipo){
	
				Label nombrePersonaje = new Label();
				nombrePersonaje.setText(personaje.getNombre() + ":");
				nombrePersonaje.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
				Label numeroVida = new Label();
				numeroVida.setText(((Integer)personaje.getSalud()).toString());
				numeroVida.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
				
				ProgressBar barraVidaParticular = new ProgressBar(); // crea la barra de vida
				barras.put(personaje, barraVidaParticular);
				this.numerosVida.put(personaje, numeroVida);
				barraVidaParticular.setProgress(personaje.getPorcentajeSalud()/100F); // Ese F es necesario
				
				
				final HBox hb = new HBox();
				hb.setAlignment(Pos.CENTER_RIGHT);
				hb.getChildren().addAll(nombrePersonaje, barraVidaParticular, numeroVida);
				this.getChildren().add(hb);
			}
		}
	}
	
	public void actualizar(){
		for (Personaje personaje : barras.keySet()){
			barras.get(personaje).setProgress(personaje.getPorcentajeSalud()/100F);
		}
		for (Personaje personaje : this.numerosVida.keySet()){
			this.numerosVida.get(personaje).setText(((Integer)personaje.getSalud()).toString());
		}
	}
}
