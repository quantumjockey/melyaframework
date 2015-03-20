package com.quantumjockey.melya.controls.standard.doubleadjuster;

import com.quantumjockey.melya.markup.scene.layout.VBoxComplement;
import com.quantumjockey.melya.controls.standard.doubleadjuster.components.DoubleAdjusterController;

public class DoubleAdjuster extends VBoxComplement<DoubleAdjusterController> {

    /////////// Protected Methods ///////////////////////////////////////////////////////////

    @Override
    protected void initializeComponents() {
        this.intializeMarkup(this, DoubleAdjusterController.class);
    }

}
