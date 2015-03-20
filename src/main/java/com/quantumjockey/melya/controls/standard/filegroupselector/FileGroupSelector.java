package com.quantumjockey.melya.controls.standard.filegroupselector;

import com.quantumjockey.melya.markup.scene.layout.VBoxComplement;
import com.quantumjockey.melya.controls.standard.filegroupselector.components.FileGroupSelectorController;

public class FileGroupSelector extends VBoxComplement<FileGroupSelectorController> {

    /////////// Protected Methods ///////////////////////////////////////////////////////////

    @Override
    protected void initializeComponents() {
        this.intializeMarkup(this, FileGroupSelectorController.class);
    }

}
