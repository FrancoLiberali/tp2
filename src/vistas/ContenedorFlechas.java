package vistas;

import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ContenedorFlechas extends GridPane{
	private List<Button> botones;
	
	public ContenedorFlechas(List<Button> botonesFlechas){
		this.setPrefWidth(50);
		botones = botonesFlechas;
		this.setTamanioFlechas();
		this.setFlechasDeArriba();
		this.setFlechasMedias();
		this.setFlechasAbajo();
	}
	public void setTamanioFlechas(){
		int i = 0;
		while (i<8){
			Button boton = botones.get(i);
			boton.setMinWidth(this.getPrefWidth());
			i++;
		}
	}
	public void setFlechasDeArriba(){
		int i = 0;
		while (i<3){
			Button boton = botones.get(i);
			this.add(boton,i,0);
			i++;
		}
	}
	
	public void setFlechasMedias(){
		this.add(botones.get(3),2,1);
		this.add(botones.get(4),0,1);
		
	}
	
	public void setFlechasAbajo(){
		int i = 5;
		while (i<8){
			Button boton = botones.get(i);
			this.add(boton, i-5, 2);
			i++;
		}
	}
}
