package melya.controls.initialization.base;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.Control;
import java.util.ArrayList;

public abstract class CollectionControlInitializer<ControlType extends Control, ItemType> extends ControlInitializer<ControlType> {

    /////////// Constructors ////////////////////////////////////////////////////////////////

    public CollectionControlInitializer(ControlType uiComponent) {
        super(uiComponent);
    }

    /////////// Public Methods //////////////////////////////////////////////////////////////

    public abstract void populate(ArrayList<ItemType> temp, ChangeListener<ItemType> onSelectionChanged);

}
