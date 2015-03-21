package com.quantumjockey.melya.controls.standard.zoomableimageview;

import com.quantumjockey.melya.controls.standard.zoomableimageview.components.ZoomableImageViewController;
import com.quantumjockey.melya.markup.scene.layout.GridPaneComplement;

public class ZoomableImageView extends GridPaneComplement<ZoomableImageViewController> {

    /////////// Protected Methods ///////////////////////////////////////////////////////////

    @Override
    protected void initializeComponents() {
        this.intializeMarkup(this, ZoomableImageViewController.class);
    }

}
