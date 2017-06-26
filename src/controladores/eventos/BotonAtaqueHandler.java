package controladores.eventos;

import java.util.Hashtable;

import javafx.event.ActionEvent;
import model.personajes.Personaje;
import vistas.CajaDeInformacionPersonaje;
import vistas.Consola;

public abstract class BotonAtaqueHandler extends BotonModificableHandler{
	protected Personaje personajeAAtacar;
	protected Hashtable<String,CajaDeInformacionPersonaje> cajas;
	protected Consola consola;
	
	public BotonAtaqueHandler(Personaje personaje, Hashtable<String,CajaDeInformacionPersonaje> cajas, Consola consola){
		personajeAAtacar = personaje;		
		this.cajas = cajas;
		this.consola = consola;
	}
	
	public Personaje getPersonaje(){
		return personajeAAtacar;
	}
	
	public abstract void handle(ActionEvent actionEvent);
	
}
