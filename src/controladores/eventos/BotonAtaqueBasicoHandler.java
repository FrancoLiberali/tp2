package controladores.eventos;

import java.util.Hashtable;

import javafx.event.ActionEvent;
import model.exceptions.FueraDeRangoException;
import model.exceptions.NoTienesAtaquesRestantesException;
import model.exceptions.PersonajeEnEstadoChocolate;
import model.exceptions.PersonajeInexistenteException;
import model.personajes.Personaje;
import vistas.CajaDeInformacionPersonaje;
import vistas.Consola;
import vistas.ReproductorEfectos;


public class BotonAtaqueBasicoHandler extends BotonModificableHandler{
	
	private Personaje personajeAAtacar;
	private Hashtable<String,CajaDeInformacionPersonaje> cajas;
	private Consola consola;
	
	public BotonAtaqueBasicoHandler(Personaje personaje, Hashtable<String,CajaDeInformacionPersonaje> cajas, Consola consola){
		personajeAAtacar = personaje;		
		this.cajas = cajas;
		this.consola = consola;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
        try{
        	this.personajeModificador.realizarAtaqueBasico(personajeAAtacar);
        	ReproductorEfectos.reproducirFX(ReproductorEfectos.ATTACK);
        	cajas.get(personajeAAtacar.getNombre()).actualizar();
        	cajas.get(this.personajeModificador.getNombre()).actualizar();
        }
        catch(NoTienesAtaquesRestantesException error){
        	ReproductorEfectos.reproducirFX(ReproductorEfectos.ERROR);
        	this.consola.agregarInformacion("Ya no tienes ataques!");
        }
        catch(PersonajeInexistenteException error){
        	ReproductorEfectos.reproducirFX(ReproductorEfectos.ERROR);
        	this.consola.agregarInformacion("Ese personaje esta muerto x(");
        }
        catch(PersonajeEnEstadoChocolate error){
        	ReproductorEfectos.reproducirFX(ReproductorEfectos.ERROR);
        	this.consola.agregarInformacion("Estas convertido en Chocolate :(");
        }
        catch(FueraDeRangoException error){
        	ReproductorEfectos.reproducirFX(ReproductorEfectos.ERROR);
        	this.consola.agregarInformacion("No! no puedes atacar mas lejos que tu distancia de ataque");
        }
	}
}