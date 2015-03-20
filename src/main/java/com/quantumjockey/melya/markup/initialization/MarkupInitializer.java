package com.quantumjockey.melya.markup.initialization;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import java.io.IOException;
import java.net.URL;

public class MarkupInitializer {

    /////////// Fields //////////////////////////////////////////////////////////////////////

    private FXMLLoader fxmlLoader;
    private URL location;

    /////////// Constructors ////////////////////////////////////////////////////////////////

    public MarkupInitializer(Class controllerClass, String markupFile) {
        this.location = controllerClass.getResource(markupFile);
        this.fxmlLoader = new FXMLLoader();
        this.fxmlLoader.setLocation(location);
        this.fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
    }

    /////////// Public Methods //////////////////////////////////////////////////////////////

    public void load(){
        try {
            this.fxmlLoader.load(this.location.openStream());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public Object getController(){
        return this.fxmlLoader.getController();
    }

    public void setRoot(Node rootObject){
        this.fxmlLoader.setRoot(rootObject);
    }

}
