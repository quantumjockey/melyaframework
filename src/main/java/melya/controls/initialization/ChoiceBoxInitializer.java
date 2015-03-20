package melya.controls.initialization;

import com.quantumjockey.mvvmbase.controls.initialization.base.CollectionControlInitializer;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import java.util.ArrayList;

public class ChoiceBoxInitializer<T> extends CollectionControlInitializer<ChoiceBox<T>, T> {

    /////////// Constructors ////////////////////////////////////////////////////////////////

    public ChoiceBoxInitializer(ChoiceBox<T> selector) {
        super(selector);
    }

    /////////// Public Methods //////////////////////////////////////////////////////////////

    @Override
    public void populate(ArrayList<T> temp, ChangeListener<T> onSelectionChanged) {
        this.initializeItems(temp);
        this.initializeSelectedItem();
        this.setOnSelectionChangedListener(onSelectionChanged);
        this.setTooltip();
    }

    /////////// Private Methods /////////////////////////////////////////////////////////////

    private void initializeItems(ArrayList<T> _temp) {
        this.markupReference.getItems().clear();
        this.markupReference.setItems(FXCollections.observableList(_temp));
    }

    private void initializeSelectedItem() {
        if (this.markupReference.getItems().size() > 0)
            this.markupReference.getSelectionModel().select(0);
    }

    private void setOnSelectionChangedListener(ChangeListener<T> _onSelectionChanged) {
        if (_onSelectionChanged != null)
            this.markupReference.valueProperty().addListener(_onSelectionChanged);
    }

    private void setTooltip() {
        this.markupReference.setTooltip(new Tooltip(this.markupReference.getSelectionModel().getSelectedItem().toString()));
    }

}
