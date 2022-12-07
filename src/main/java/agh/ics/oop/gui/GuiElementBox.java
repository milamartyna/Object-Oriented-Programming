package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {

    private static final int SIZE = 20;
    private final VBox vbox;

    public GuiElementBox(IMapElement element) throws FileNotFoundException {

        ImageView imageView;
        try {
            Image image = new Image(new FileInputStream(element.getImagePath()));
            imageView = new ImageView(image);
            imageView.setFitWidth(SIZE);
            imageView.setFitHeight(SIZE);
        } catch (FileNotFoundException e){
            throw new FileNotFoundException(e.getMessage());
        }

        Label positionLabel = new Label(element.position().toString());
        this.vbox = new VBox(imageView, positionLabel);
        vbox.setAlignment(Pos.CENTER);
    }

    public VBox getVBox(){
        return this.vbox;
    }

}
