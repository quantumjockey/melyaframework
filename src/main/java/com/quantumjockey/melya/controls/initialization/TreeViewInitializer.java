package com.quantumjockey.melya.controls.initialization;

import com.quantumjockey.melya.controls.initialization.base.ControlInitializer;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.*;
import javafx.util.Callback;

public class TreeViewInitializer<T> extends ControlInitializer<TreeView<T>> {

    /////////// Constructors ////////////////////////////////////////////////////////////////

    public TreeViewInitializer(TreeView<T> selector) {
        super(selector);
    }

    /////////// Public Methods //////////////////////////////////////////////////////////////

    public void populate(TreeItem<T> root, SelectionMode mode, boolean canEdit, Callback<TreeView<T>, TreeCell<T>> cellFactory, ChangeListener<TreeItem<T>> selectionChangedEvent) {
        root.setExpanded(true);
        this.markupReference.setRoot(root);
        this.initializeEditing(canEdit);
        this.initializeCellFactory(cellFactory);
        this.initializeSelection(mode);
        this.initializeSelectionChangedEvents(selectionChangedEvent);
    }

    /////////// Private Methods /////////////////////////////////////////////////////////////

    private void initializeCellFactory(Callback<TreeView<T>, TreeCell<T>> _cellFactory) {
        if (_cellFactory != null)
            this.markupReference.setCellFactory(_cellFactory);
    }

    private void initializeEditing(boolean _canEdit) {
        this.markupReference.setEditable(_canEdit);
    }

    private void initializeSelection(SelectionMode _mode) {
        if (_mode == SelectionMode.MULTIPLE)
            this.markupReference.getSelectionModel().setSelectionMode(_mode);
        else {
            this.markupReference.getSelectionModel().setSelectionMode(_mode);
            this.markupReference.getSelectionModel().select(0);
        }
    }

    private void initializeSelectionChangedEvents(ChangeListener<TreeItem<T>> _selectedChanged) {
        if (_selectedChanged != null)
            this.markupReference.getSelectionModel().selectedItemProperty().addListener(_selectedChanged);
    }

}
