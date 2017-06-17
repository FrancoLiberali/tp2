package vistas;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;
import vista.eventos.OpcionAcercaDeEventHandler;
import vista.eventos.OpcionMudoEventHandler;
import vista.eventos.OpcionPantallaCompletaEventHandler;
import vista.eventos.OpcionSalirEventHandler;

public class BarraDeMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");
    MenuItem opcionMudo = new MenuItem("Mudo");

    public BarraDeMenu(Stage stage , Reproductor reproductor) {

        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuAudio = new Menu("Audio");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAbrir = new MenuItem("Abrir");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");

        OpcionSalirEventHandler opcionSalirHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirHandler);

        OpcionAcercaDeEventHandler opcionAcercaDeHandler = new OpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(opcionAcercaDeHandler);

        OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);
        
        OpcionMudoEventHandler opcionMudoHandler = new OpcionMudoEventHandler(reproductor, opcionMudo);
        opcionMudo.setOnAction(opcionMudoHandler);

        opcionPantallaCompleta.setDisable(true);

        menuArchivo.getItems().addAll(opcionAbrir, new SeparatorMenuItem(), opcionSalir);
        menuAyuda.getItems().addAll(opcionAcercaDe);
        menuVer.getItems().addAll(opcionPantallaCompleta);
        menuAudio.getItems().addAll(opcionMudo);

        this.getMenus().addAll(menuArchivo, menuVer,menuAudio, menuAyuda);
    }

    public void aplicacionMaximizada() {
        opcionPantallaCompleta.setDisable(false);

    }
}
