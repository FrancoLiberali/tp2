package personajes.elementos;

import java.io.File;

import javafx.scene.media.AudioClip;

public class AtaqueEspecial {
	protected Ki kiNecesario;
	private String nombre;
	private int porcentaje = 0;
	private String rutaSonido;
	
	public AtaqueEspecial(String nombre,int ki,String sonido){
		this.kiNecesario = new Ki(ki);
		this.nombre = nombre;
		this.rutaSonido = sonido;
	}
	
	public void setPorcentaje(int porcentaje){
		this.porcentaje = porcentaje;
	}
	
	public int getPorcentaje( Ki kiPersonaje){
		kiPersonaje.restar(kiNecesario);
		return porcentaje;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void ReproducirAtaque(){
		
		File archivo = new File(rutaSonido);
		AudioClip sonidoAtaque = new AudioClip(archivo.toURI().toString());
		sonidoAtaque.play();
		
	}
}
