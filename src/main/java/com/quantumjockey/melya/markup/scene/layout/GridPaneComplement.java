package com.quantumjockey.melya.markup.scene.layout;

import com.quantumjockey.melya.markup.initialization.MarkupInitializer;
import com.quantumjockey.melya.markup.initialization.MarkupInitializerMacro;
import com.quantumjockey.melya.markup.scene.MarkupInitializable;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public abstract class GridPaneComplement<GenericController> extends GridPane implements MarkupInitializable<GenericController> {

    /////////// Fields //////////////////////////////////////////////////////////////////////

    private MarkupInitializer markupContainer;

    /////////// Constructors ////////////////////////////////////////////////////////////////

    public GridPaneComplement() {
        this.initializeComponents();
        this.loadControl();
    }

    /////////// Public Methods //////////////////////////////////////////////////////////////

    @SuppressWarnings("unchecked")
    public GenericController getController() {
        return (GenericController) this.markupContainer.getController();
    }

    /////////// Protected Methods ///////////////////////////////////////////////////////////

    protected abstract void initializeComponents();

    protected void intializeMarkup(Node rootObject, Class controllerClass) {
        this.markupContainer = MarkupInitializerMacro.createInitializer(rootObject, controllerClass);
    }

    /////////// Private Methods /////////////////////////////////////////////////////////////

    private void loadControl() {
        this.markupContainer.load();
    }

}
