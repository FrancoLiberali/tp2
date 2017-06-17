package vistas;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;;

public class Reproductor {
	
	String path = "file:src/vista/musica/musicaDeFondo.mp3";
	Media media = new Media(new File(path).toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	
	
	public void reproducionAutomitica(boolean estado){
		
		mediaPlayer.setAutoPlay(estado);
		
	}
	
	public void pausar(){
		
		mediaPlayer.pause();;
	}
}
