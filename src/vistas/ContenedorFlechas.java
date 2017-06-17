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
		int i = 6;
		while (i<14){
			Button boton = botones.get(i);
			boton.setMinWidth(this.getPrefWidth());
			i++;
		}
	}
	public void setFlechasDeArriba(){
		int i = 6;
		while (i<9){
			Button boton = botones.get(i);
			this.add(boton,i-6,0);
			i++;
		}
	}
	
	public void setFlechasMedias(){
		this.add(botones.get(9),2,1);
		this.add(botones.get(13),0,1);
		
	}
	
	public void setFlechasAbajo(){
		int i = 12;
		while (i>9){
			Button boton = botones.get(i);
			this.add(boton, 12-i, 2);
			i--;
		}
	}
}
