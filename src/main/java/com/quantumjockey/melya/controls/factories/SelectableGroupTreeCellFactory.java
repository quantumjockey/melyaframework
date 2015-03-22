package com.quantumjockey.melya.controls.factories;

/*
 * ContextMenu display on right click created via custom implementation of Ex.13-4, Fig.13-5 in "Using JavaFX UI Controls: (13) TreeView"
 * from < http://docs.oracle.com/javafx/2/ui_controls/tree-view.htm > as accessed on 11/2/2014
 */

import javafx.scene.control.*;

public class SelectableGroupTreeCellFactory extends TreeCell<String> {

    /////////// Fields //////////////////////////////////////////////////////////////////////

    private TextField textField;
    private ContextMenu addMenu = new ContextMenu();

    /////////// Constructors ////////////////////////////////////////////////////////////////

    public SelectableGroupTreeCellFactory() {
        MenuItem addMenuItem = new MenuItem("Select all in group");
        this.addMenu.getItems().add(addMenuItem);
        addMenuItem.setOnAction((action) -> {
            for (TreeItem<String> item : super.getTreeItem().getChildren()) {
                super.getTreeView().getSelectionModel().select(item);
            }
        });
    }

    /////////// Public Methods //////////////////////////////////////////////////////////////

    /*
     * The updateItem() method written below has been copied temporarily from the tutorial (link above) for sake of
     * obtaining desired functionality and is neither original, nor templated code. The content of this method will be
     * changed as soon as a more applicable approach is devised.
     */
    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            super.setText(null);
            super.setGraphic(null);
        } else {
            if (isEditing()) {
                if (this.textField != null)
                    this.textField.setText(getItem());
                super.setText(null);
                super.setGraphic(this.textField);
            } else {
                super.setText(super.getItem());
                super.setGraphic(super.getTreeItem().getGraphic());
                if (!super.getTreeItem().isLeaf() && super.getTreeItem().getParent() != null)
                    super.setContextMenu(this.addMenu);
            }
        }
    }

}
