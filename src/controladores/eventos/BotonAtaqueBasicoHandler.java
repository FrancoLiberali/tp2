package controladores.eventos;

import javafx.event.ActionEvent;
import model.exceptions.FueraDeRangoException;
import model.exceptions.NoTienesAtaquesRestantesException;
import model.exceptions.PersonajeEnEstadoChocolate;
import model.exceptions.PersonajeInexistenteException;
import model.personajes.Personaje;
import vistas.BarrasDeVida;
import vistas.Consola;
import vistas.ReproductorEfectos;


public class BotonAtaqueBasicoHandler extends BotonModificableHandler{
	
	private Personaje personajeAAtacar;
	private BarrasDeVida barras;
	private Consola consola;
	
	public BotonAtaqueBasicoHandler(Personaje personaje, BarrasDeVida barras, Consola consola){
		personajeAAtacar = personaje;		
		this.barras = barras;
		this.consola = consola;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
        try{
        	this.personajeModificador.realizarAtaqueBasico(personajeAAtacar);
        	ReproductorEfectos.reproducirFX(ReproductorEfectos.ATTACK);
        	barras.actualizar();
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