package com.quantumjockey.melya.controls.initialization;

import com.quantumjockey.melya.controls.initialization.base.CollectionControlInitializer;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import java.util.ArrayList;

public class ListViewInitializer<T> extends CollectionControlInitializer<ListView<T>, T> {

    /////////// Constructors ////////////////////////////////////////////////////////////////

    public ListViewInitializer(ListView<T> selector) {
        super(selector);
        this.markupReference.setEditable(false);
    }

    /////////// Public Methods //////////////////////////////////////////////////////////////

    @Override
    public void populate(ArrayList<T> temp, ChangeListener<T> onSelectionChanged) {
        SelectionMode defaultMode = SelectionMode.SINGLE;
        this.initializeItems(temp);
        this.initializeSelection(defaultMode);
        this.setOnSelectionChangedListener(onSelectionChanged);
        this.setTooltip(defaultMode);
    }

    public void updateEditing(boolean _canEdit) {
        this.markupReference.setEditable(_canEdit);
    }

    public void updateSelectionMode(SelectionMode mode){
        this.initializeSelection(mode);
    }

    /////////// Private Methods /////////////////////////////////////////////////////////////

    private void initializeItems(ArrayList<T> _temp) {
        this.markupReference.getItems().clear();
        this.markupReference.setItems(FXCollections.observableList(_temp));
    }

    private void initializeSelection(SelectionMode _mode) {
        this.markupReference.getSelectionModel().setSelectionMode(_mode);
        if (_mode == SelectionMode.SINGLE)
            this.markupReference.getSelectionModel().select(0);
    }

    private void setOnSelectionChangedListener(ChangeListener<T> _onSelectionChanged) {
        if (_onSelectionChanged != null)
            this.markupReference.getSelectionModel().selectedItemProperty().addListener(_onSelectionChanged);
    }

    private void setTooltip(SelectionMode _mode) {
        if (_mode == SelectionMode.SINGLE)
            this.markupReference.setTooltip(new Tooltip(this.markupReference.getSelectionModel().getSelectedItem().toString()));
    }

}
