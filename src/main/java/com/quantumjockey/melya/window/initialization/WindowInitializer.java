package com.quantumjockey.melya.window.initialization;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.ArrayList;

public class WindowInitializer {

    /////////// Fields ///////////////////////////////////////////////////////////////////////

    private FXMLLoader windowLoader;
    private Parent windowRoot;
    private ArrayList<String> styleSheets;

    /////////// Constructor(s) ////////////////////////////////////////////////////////////////

    public WindowInitializer(String markupFileName, Object controllerInstance, Class callingObject) throws Exception {
        this.styleSheets = new ArrayList<>();
        this.windowLoader = new FXMLLoader();
        this.windowLoader.setController(controllerInstance);
        this.windowRoot = this.windowLoader.load(callingObject.getResource(markupFileName));
    }

    /////////// Public Methods ////////////////////////////////////////////////////////////////

    public void appendCssStyles(String cssFilename, Class callingObject){
        styleSheets.add(callingObject.getResource(cssFilename).toExternalForm());
    }

    public Scene getScene() {
        Scene window = new Scene(this.windowRoot);
        if (styleSheets.size() != 0)
            window.getStylesheets().addAll(styleSheets);
        return window;
    }

    public Scene getScene(int height, int width){
        return new Scene(this.windowRoot, width, height);
    }

}
