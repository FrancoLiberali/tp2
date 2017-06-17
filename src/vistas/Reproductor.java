package vistas;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;;

public class Reproductor {
	
	String path = "src/vista/musica/musicaDeFondo.mp3";
	File archivo = new File(path);
	Media media = new Media(archivo.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media); 
	
	public void reproducionAutomitica(boolean estado){
		
		mediaPlayer.setAutoPlay(estado);
		
	}
	
	public void pausar(){
		
		mediaPlayer.pause();
	}
}
