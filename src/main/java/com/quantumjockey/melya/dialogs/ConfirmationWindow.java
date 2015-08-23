package com.quantumjockey.melya.dialogs;

import com.quantumjockey.melya.dialogs.base.ModalWindow;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ConfirmationWindow extends ModalWindow {

    /////////// Fields ////////////////////////////////////////////////////////////////////////

    private Runnable actionUponConfirmation;

    /////////// Constructors //////////////////////////////////////////////////////////////////

    public ConfirmationWindow(String title, String message, Runnable action) {
        this.initializeModalWindow(title, message);
        this.actionUponConfirmation = action;
    }

    /////////// Private Methods ///////////////////////////////////////////////////////////////

    @Override
    protected void generateLayout(String text) {
        VBox box = new VBox(this.VERTICAL_SPACING);

        Label messageText = new Label(text);
        messageText.setWrapText(true);
        messageText.setStyle("-fx-padding: 5;");

        Button okResponse = new Button("Ok");
        okResponse.setOnAction((event) -> {
            this.actionUponConfirmation.run();
            this.modalDialog.close();
        });

        Button cancelResponse = new Button("Cancel");
        cancelResponse.setOnAction((event) -> this.modalDialog.close());

        HBox buttonContainer = new HBox(this.HORIZONTAL_SPACING);
        buttonContainer.getChildren().addAll(cancelResponse, okResponse);
        buttonContainer.setAlignment(Pos.CENTER);

        box.getChildren().addAll(messageText, buttonContainer);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(this.BOX_PADDING));
        this.modalDialog.setScene(new Scene(box));
    }

}
