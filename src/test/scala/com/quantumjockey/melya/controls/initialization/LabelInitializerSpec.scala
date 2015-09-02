package com.quantumjockey.melya.controls.initialization

import com.quantumjockey.melya.test.JavaFXSpecRunner
import javafx.scene.control.Label
import javafx.scene.image.{ImageView, Image}
import org.scalatest.{BeforeAndAfter, FunSpec}

class LabelInitializerSpec extends FunSpec with JavaFXSpecRunner with BeforeAndAfter {

  // Fields
  var label: Label = null
  var initializer: LabelInitializer = null

  val text: String = "Hat's off!"
  val tip: String =  "To you!"

  // Setup/Teardown

  before {
    this.initializeJavaFXToolkit()
    this.label = new Label()
    this.initializer = new LabelInitializer(label)
  }

  // Requirements

  describe("A label control initialization object") {

    it("should insert the specified text") {
      this.initializer.update(this.text, "")
      val labelText: String = this.label.getText
      assert(this.text == labelText)
    }

    it("should set/display a tooltip containing the specified text") {
      this.initializer.update("", this.tip)
      val tooltip: String = this.label.getTooltip.getText
      assert(this.tip == tooltip)
    }

  }

}
