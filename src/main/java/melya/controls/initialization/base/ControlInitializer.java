package melya.controls.initialization.base;

import javafx.scene.control.Control;

public abstract class ControlInitializer<T extends Control> {

    /////////// Fields //////////////////////////////////////////////////////////////////////

    protected T markupReference;

    /////////// Constructors ////////////////////////////////////////////////////////////////

    public ControlInitializer(T uiComponent) {
        markupReference = uiComponent;
    }

}
