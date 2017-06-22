package model.personajes.elementos;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import model.personajes.Personaje;


public class PanelCaracteristicas {
	
	Hashtable<String,Hashtable<String, Integer>> caracteristicas = new Hashtable<String, Hashtable<String, Integer>>();
	Hashtable<String,Hashtable<String, Integer>> caracteristicasTransformacion = new Hashtable<String, Hashtable<String, Integer>>();
	
	public void setCaracteristicas(Personaje personaje){
		Hashtable<String, Integer> caracteristicaDelPersonaje = personaje.darCaracteriticas();
		Hashtable<String, Integer> caracteristicaDeTranformacion = personaje.darCaracteriticasTransormacion();
		caracteristicas.put(personaje.getNombre(), caracteristicaDelPersonaje);
		caracteristicasTransformacion.put(personaje.getNombre(), caracteristicaDeTranformacion);
		
	}
	
	public int mostrarCaracteristica(String nombrePersonaje ,String caracteristica){
		
		return this.caracteristicas.get(nombrePersonaje).get(caracteristica);
		
	}
		
	public int mostrarCaracteristicaTransformacion(String nombrePersonaje ,String caracteristica){
		
		return this.caracteristicasTransformacion.get(nombrePersonaje).get(caracteristica);
		
	}
	
	public ArrayList<String> caracteristicas(){
		
		ArrayList<String> caracteristicas = new ArrayList<String>();
		
		Enumeration<Hashtable<String, Integer>> caracteristica = this.caracteristicas.elements();
		Hashtable<String, Integer> personaje;
		if( caracteristica .hasMoreElements() ){
		  personaje = caracteristica.nextElement();
		  Enumeration<String> personajes =  personaje.keys();
		  String valor;
		  while( personajes.hasMoreElements() ){
			  valor = personajes.nextElement();
			  caracteristicas.add(valor);
		  }
		  
		}
		return caracteristicas;
		
	}
	
	
	public ArrayList<String> caracteristicasTransformacion(){
		
		ArrayList<String> caracteristicas = new ArrayList<String>();
		
		Enumeration<Hashtable<String, Integer>> caracteristica = this.caracteristicasTransformacion.elements();
		Hashtable<String, Integer> personaje;
		if( caracteristica .hasMoreElements() ){
		  personaje = caracteristica.nextElement();
		  Enumeration<String> personajes =  personaje.keys();
		  String valor;
		  while( personajes.hasMoreElements() ){
			  valor = personajes.nextElement();
			  caracteristicas.add(valor);
		  }
		  
		}
		return caracteristicas;
		
	}
	
	
	public ArrayList<String> Personajes(){
		
		ArrayList<String> caracteristicas = new ArrayList<String>();
		
		Enumeration<String> caracteristica = this.caracteristicas.keys();
		String personaje;
		while( caracteristica .hasMoreElements() ){
		  personaje = caracteristica.nextElement();
		  caracteristicas.add(personaje);
		  }
		return caracteristicas;
		
	}
	
}
