package com.quantumjockey.melya.controls.standard.valueadjuster;

import com.quantumjockey.melya.markup.scene.layout.VBoxComplement;
import com.quantumjockey.melya.controls.standard.valueadjuster.components.ValueAdjusterController;

public class ValueAdjuster extends VBoxComplement<ValueAdjusterController> {

    /////////// Protected Methods ///////////////////////////////////////////////////////////

    @Override
    protected void initializeComponents() {
        this.intializeMarkup(this, ValueAdjusterController.class);
    }

}
