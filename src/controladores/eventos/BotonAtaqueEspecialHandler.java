package controladores.eventos;

import vistas.CajaDeInformacionPersonaje;
import vistas.Consola;

import java.util.Hashtable;

import javafx.event.ActionEvent;
import model.exceptions.FueraDeRangoException;
import model.exceptions.KiInsuficienteException;
import model.exceptions.NoTienesAtaquesRestantesException;
import model.exceptions.PersonajeEnEstadoChocolate;
import model.exceptions.PersonajeInexistenteException;
import model.personajes.Personaje;

public class BotonAtaqueEspecialHandler extends BotonAtaqueHandler{
	
	public BotonAtaqueEspecialHandler(Personaje personaje, Hashtable<String,CajaDeInformacionPersonaje> cajas, Consola consola){
		super(personaje,cajas,consola);
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
        try{
        	this.personajeModificador.realizarAtaqueEspecial(personajeAAtacar);
        	cajas.get(personajeAAtacar.getNombre()).actualizar();
        }
        catch(NoTienesAtaquesRestantesException error){
        	this.consola.agregarInformacion("Ya no tienes ataques!");
        }
		catch( KiInsuficienteException error){
			this.consola.agregarInformacion("Ki insuficiente");
		}
        catch(PersonajeEnEstadoChocolate error){
        	this.consola.agregarInformacion("Estas convertido en Chocolate :(");
        }
        catch(PersonajeInexistenteException error){
        	this.consola.agregarInformacion("Ese personaje esta muerto x(");
        }
        catch(FueraDeRangoException error){
        	this.consola.agregarInformacion("No! no puedes atacar mas lejos que tu distancia de ataque");
        }
    }
}
