package vistas;

import controladores.eventos.OpcionAcercaDeEventHandler;
import controladores.eventos.OpcionAyudaEventHandler;
import controladores.eventos.OpcionMudoEventHandler;
import controladores.eventos.OpcionPantallaCompletaEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class BarraDeMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");
    MenuItem opcionMudo = new MenuItem("Mudo");

    public BarraDeMenu(Stage stage , Reproductor reproductor) {

        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuAudio = new Menu("Audio");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");
        MenuItem opcionAyuda = new MenuItem("Ayuda...");

        opcionSalir.setOnAction(event ->
        stage.fireEvent( new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST)));

        OpcionAcercaDeEventHandler opcionAcercaDeHandler = new OpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(opcionAcercaDeHandler);
        
        OpcionAyudaEventHandler opcionAyudaHandler = new OpcionAyudaEventHandler();
        opcionAyuda.setOnAction(opcionAyudaHandler);

        OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);
        
        OpcionMudoEventHandler opcionMudoHandler = new OpcionMudoEventHandler(reproductor);
        opcionMudo.setOnAction(opcionMudoHandler);

        opcionPantallaCompleta.setDisable(true);

        menuArchivo.getItems().addAll(opcionSalir);
        menuAyuda.getItems().addAll(opcionAcercaDe);
        menuAyuda.getItems().addAll(opcionAyuda);
        menuVer.getItems().addAll(opcionPantallaCompleta);
        menuAudio.getItems().addAll(opcionMudo);

        this.getMenus().addAll(menuArchivo, menuVer,menuAudio, menuAyuda);
    }

    public void aplicacionMaximizada() {
        opcionPantallaCompleta.setDisable(false);

    }
}
