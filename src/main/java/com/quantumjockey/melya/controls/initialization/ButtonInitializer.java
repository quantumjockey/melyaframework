package com.quantumjockey.melya.controls.initialization;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonInitializer {

    /////////// Fields //////////////////////////////////////////////////////////////////////

    private Button button;

    /////////// Constructors ////////////////////////////////////////////////////////////////

    public ButtonInitializer(Button button){
        this.button = button;
    }

    /////////// Public Methods //////////////////////////////////////////////////////////////

    public void setSkin(Image imageResource){
        this.button.setGraphic(new ImageView(imageResource));
    }

    public void setTooltip(String tooltip){
        this.button.setTooltip(new Tooltip(tooltip));
    }
}
