package controladores.eventos;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OpcionAyudaEventHandler implements EventHandler<ActionEvent> {

	private String path = "src/vistas/documentos/ayuda.pdf";
    @Override
    public void handle(ActionEvent actionEvent) {
    	File file=new File(path);
    	if (Desktop.isDesktopSupported()){
    		Desktop desktop = Desktop.getDesktop();
    		try {
    			desktop.open(file);
    		} catch (IOException ex) {}
    	}
    }

}
