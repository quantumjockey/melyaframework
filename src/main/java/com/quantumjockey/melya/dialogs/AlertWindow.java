package com.quantumjockey.melya.dialogs;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AlertWindow {

    /////////// Constants /////////////////////////////////////////////////////////////////////

    private final int BOX_PADDING = 20;
    private final int VERTICAL_SPACING = 15;

    /////////// Fields ////////////////////////////////////////////////////////////////////////

    private Stage alertDialog;

    /////////// Constructors //////////////////////////////////////////////////////////////////

    public AlertWindow(String title, String message) {
        this.alertDialog = new Stage();
        this.alertDialog.setTitle(title);
        this.setStyles();
        this.generateLayout(message);
    }

    /////////// Public Methods ////////////////////////////////////////////////////////////////

    public void show() {
        this.alertDialog.show();
    }

    /////////// Private Methods ///////////////////////////////////////////////////////////////

    private void generateLayout(String text) {
        VBox box = new VBox(this.VERTICAL_SPACING);
        Label messageText = new Label(text);
        Button response = new Button("Ok");
        response.setOnAction((event) -> this.alertDialog.close());
        box.getChildren().addAll(messageText, response);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(this.BOX_PADDING));
        this.alertDialog.setScene(new Scene(box));
    }

    private void setStyles() {
        this.alertDialog.initStyle(StageStyle.UTILITY);
        this.alertDialog.initModality(Modality.WINDOW_MODAL);
    }

}
