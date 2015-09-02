package com.quantumjockey.melya.controls.initialization

import com.quantumjockey.melya.icons.IconLibrary
import com.quantumjockey.melya.test.JavaFXSpecRunner
import javafx.scene.control.Button
import javafx.scene.image.{ImageView, Image}
import org.scalatest.{BeforeAndAfter, FunSpec}

class ButtonInitializerSpec extends FunSpec with JavaFXSpecRunner with BeforeAndAfter {

  // Fields
  var button: Button = null
  var initializer: ButtonInitializer = null
  var image: Image = null

  // Setup/Teardown

  before {
    this.initializeJavaFXToolkit()
    this.button = new Button()
    this.initializer = new ButtonInitializer(button)
    val library: IconLibrary = new IconLibrary()
    this.image = library.getRootIcon
  }

  // Requirements

  describe("A button control initialization object") {

    it("should skin the control with specified background") {
      this.initializer.setSkin(image)
      val graphic: Image = (this.button.getGraphic match {
        case imgvw: ImageView => imgvw
        case _ => throw new ClassCastException
      }).getImage
      assert(this.image == graphic)
    }

    it("should set/display a tooltip containing the specified text") {
      val tip: String =  "the hat"
      this.initializer.setTooltip(tip)
      val tooltip: String = this.button.getTooltip.getText
      assert(tip == tooltip)
    }

  }

}
