package com.quantumjockey.melya.markup.initialization;

import javafx.scene.Node;

public class MarkupInitializerMacro {

    /////////// Public Methods //////////////////////////////////////////////////////////////

    public static MarkupInitializer createInitializer(Node _rootObject, Class _controllerClass) {
        return createInitializer(_rootObject, _controllerClass, generateConventionalMarkupFilename(_rootObject));
    }

    public static MarkupInitializer createInitializer(Node _rootObject, Class _controllerClass, String _markupName) {
        MarkupInitializer markupContainer = new MarkupInitializer(_controllerClass, _markupName);
        markupContainer.setRoot(_rootObject);
        return markupContainer;
    }

    /////////// Private Methods /////////////////////////////////////////////////////////////

    private static String generateConventionalMarkupFilename(Node _root) {
        return _root.getClass().getSimpleName() + "View.fxml";
    }

}
