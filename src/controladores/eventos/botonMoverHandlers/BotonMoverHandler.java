package controladores.eventos.botonMoverHandlers;

import java.util.Hashtable;

import model.algoBall.Equipo;
import model.exceptions.CasilleroOcupadoException;
import model.exceptions.EstePersonajeNoSePuedeMoverException;
import model.exceptions.FueraDelTableroException;
import model.exceptions.NoQuedanMovimientosException;
import model.personajes.Personaje;
import model.personajes.elementos.Direccion;
import vistas.CajaDeInformacionPersonaje;
import vistas.Consola;


public class BotonMoverHandler {
	private Consola consola;
	private Hashtable<String,CajaDeInformacionPersonaje> cajas;
	
	public BotonMoverHandler(Consola consola, Hashtable<String,CajaDeInformacionPersonaje> cajas){
		this.consola = consola;
		this.cajas = cajas;
	}
	
	public void mover(Equipo equipo, Personaje personaje, Direccion direccion){
		try{
    		equipo.mover(personaje, direccion);
        	cajas.get(personaje.getNombre()).actualizar();
        	consola.reiniciar();

  

    	}
    	catch(NoQuedanMovimientosException error){
     		
    	   this.consola.agregarInformacion("No te quedan movimientos!");
    	}
    	catch(EstePersonajeNoSePuedeMoverException e){
     		
    	   this.consola.agregarInformacion("No se puede mover este personaje");
        }
    	catch (CasilleroOcupadoException error){
     		
    	   this.consola.agregarInformacion("La posicion a la que intentas moverte ya esta ocupada");
    	}
		catch (FueraDelTableroException error){
	 		
			this.consola.agregarInformacion("Estas intentando moverte fuera del tablero");
		}
	}
}
