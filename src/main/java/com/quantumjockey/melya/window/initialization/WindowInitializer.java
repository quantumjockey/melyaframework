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
        this.appendDefaultCssStyles();
    }

    /////////// Public Methods ////////////////////////////////////////////////////////////////

    public void appendCssStyles(String cssFilename, Class callingObject){
        this.styleSheets.add(callingObject.getResource(cssFilename).toExternalForm());
    }

    public Scene getScene() {
        Scene window = new Scene(this.windowRoot);
        if (this.styleSheets.size() != 0)
            window.getStylesheets().addAll(this.styleSheets);
        return window;
    }

    public Scene getScene(int height, int width){
        return new Scene(this.windowRoot, width, height);
    }

    /////////// Private Methods ///////////////////////////////////////////////////////////////

    private void appendDefaultCssStyles(){
        String stylesheetBasePath = "/com/quantumjockey/melya/controls/styles/";
        this.styleSheets.add(this.getClass().getResource(stylesheetBasePath + "control/default-control-styles.css").toExternalForm());
        this.styleSheets.add(this.getClass().getResource(stylesheetBasePath + "layout/default-layout-styles.css").toExternalForm());
    }

}
