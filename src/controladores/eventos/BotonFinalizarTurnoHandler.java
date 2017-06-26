package controladores.eventos;

import java.util.Enumeration;
import java.util.Hashtable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.algoBall.AlgoBall;
import vistas.BarrasDeVida;
import vistas.CajaDeInformacionPersonaje;
import vistas.Consola;
import vistas.ReproductorEfectos;
import vistas.VistaTablero;

public class BotonFinalizarTurnoHandler implements EventHandler<ActionEvent> {
	
	Stage stage;
    Scene proximaEscena;
    AlgoBall juego;
    VistaTablero proximaVista;
    BarrasDeVida proximasBarras;
    Hashtable<String,CajaDeInformacionPersonaje> cajas;
    
 
    
    public BotonFinalizarTurnoHandler(Stage stage, AlgoBall juego, Consola consola,Hashtable<String,CajaDeInformacionPersonaje> cajas) {
        this.stage = stage;
        this.juego = juego;
        this.cajas = cajas;
    }
    
    public void setProximaEscena(Scene proximaEscena){
    	this.proximaEscena = proximaEscena;
    }
    
    public void setProximaVista(VistaTablero proximaVista){
    	this.proximaVista = proximaVista;
    }
    
    public void setProximasBarras(BarrasDeVida proximasBarras){
    	this.proximasBarras = proximasBarras;
    }
    
    public void actualizarCajas(){
    	Enumeration<CajaDeInformacionPersonaje> cajas = this.cajas.elements();
    	CajaDeInformacionPersonaje caja;
    	while( cajas.hasMoreElements() ){
    	  caja = cajas.nextElement();
    	  caja.actualizar();
    	}
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        proximaVista.update();
        this.actualizarCajas();//
    	stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        juego.finalizarTurno();
    	ReproductorEfectos.reproducirFX(ReproductorEfectos.ENDTURN);
    }
}