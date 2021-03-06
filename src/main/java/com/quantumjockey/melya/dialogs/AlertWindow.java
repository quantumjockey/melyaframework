package com.quantumjockey.melya.dialogs;

import com.quantumjockey.melya.dialogs.base.ModalWindow;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AlertWindow extends ModalWindow {

    /////////// Constructors //////////////////////////////////////////////////////////////////

    public AlertWindow(String title, String message) {
        this.initializeModalWindow(title, message);
    }

    /////////// Private Methods ///////////////////////////////////////////////////////////////

    @Override
    protected void generateLayout(String text) {
        VBox box = new VBox(this.VERTICAL_SPACING);

        Label messageText = new Label(text);
        messageText.setWrapText(true);
        messageText.setStyle("-fx-padding: 5;");

        Button response = new Button("Ok");
        response.setOnAction((event) -> this.modalDialog.close());

        box.getChildren().addAll(messageText, response);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(this.BOX_PADDING));
        this.modalDialog.setScene(new Scene(box));
    }

}
