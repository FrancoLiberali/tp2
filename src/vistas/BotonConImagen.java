package vistas;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class BotonConImagen extends Button {

    public void updateImages(String imagen) {
        Image imagenAAgregar = new Image(imagen);
    	final ImageView iv = new ImageView(imagenAAgregar);
        this.getChildren().add(iv);

        iv.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent evt) {
                iv.setImage(imagenAAgregar);
            }
        });
        iv.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent evt) {
                iv.setImage(imagenAAgregar);
            }
        });

        super.setGraphic(iv);
    }
}