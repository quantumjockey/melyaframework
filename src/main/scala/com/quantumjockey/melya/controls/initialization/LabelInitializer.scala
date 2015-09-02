package com.quantumjockey.melya.controls.initialization

import com.quantumjockey.melya.controls.initialization.base.ControlInitializer
import javafx.scene.control.{Tooltip, Label}

class LabelInitializer(label: Label) extends ControlInitializer[Label](label) {

  // Public Methods

  def update(text: String, tooltip: String) {
    this.markupReference.setText(text)
    this.setTooltip(tooltip)
  }

  // Private Methods

  private def setTooltip(tooltip: String) {
    if (tooltip != null && !tooltip.equals(""))
      this.markupReference.setTooltip(new Tooltip(tooltip));
  }

}
