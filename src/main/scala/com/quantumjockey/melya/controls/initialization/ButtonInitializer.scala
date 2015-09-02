package com.quantumjockey.melya.controls.initialization

import javafx.scene.control.{Tooltip, Button}
import javafx.scene.image.{ImageView, Image}

class ButtonInitializer(button: Button) {

  // Public Methods

  def setSkin(imageResource: Image): Unit = this.button.setGraphic(new ImageView(imageResource))

  def setTooltip(tooltip: String): Unit = this.button.setTooltip(new Tooltip(tooltip))

}
