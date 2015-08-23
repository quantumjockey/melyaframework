package com.quantumjockey.melya.dialogs.base;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public abstract class ModalWindow {

    /////////// Constants /////////////////////////////////////////////////////////////////////

    protected final int BOX_PADDING = 20;
    protected final int HORIZONTAL_SPACING = 20;
    protected final int VERTICAL_SPACING = 15;

    /////////// Fields ////////////////////////////////////////////////////////////////////////

    protected Stage modalDialog;

    /////////// Public Methods ////////////////////////////////////////////////////////////////

    public void show() {
        this.modalDialog.show();
    }

    /////////// Private Methods ///////////////////////////////////////////////////////////////

    protected abstract void generateLayout(String text);

    protected void initializeModalWindow(String title, String message) {
        this.modalDialog = new Stage();
        this.modalDialog.setTitle(title);
        this.setStyles();
        this.generateLayout(message);
    }

    protected void setStyles() {
        this.modalDialog.initStyle(StageStyle.UTILITY);
        this.modalDialog.initModality(Modality.WINDOW_MODAL);
    }

}
