package com.quantumjockey.melya.controls.standard.valueadjuster.components;

import com.quantumjockey.melya.markup.MarkupControllerBase;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

import java.text.NumberFormat;

public class ValueAdjusterController extends MarkupControllerBase {

    /////////// Constants ///////////////////////////////////////////////////////////////////

    private final int SLIDER_MAX_DEFAULT = 1000;
    private final int SLIDER_MIN_DEFAULT = 0;

    /////////// Fields //////////////////////////////////////////////////////////////////////

    @FXML
    private TextField value;

    @FXML
    private Slider adjustment;

    /////////// Properties //////////////////////////////////////////////////////////////////

    private IntegerProperty displayedValue = new SimpleIntegerProperty();

    public final int getDisplayedValue() {
        return this.displayedValue.get();
    }

    public final void setDisplayedValue(int displayedValue) {
        this.displayedValue.set(displayedValue);
    }

    public IntegerProperty displayedValueProperty() {
        return this.displayedValue;
    }

    private IntegerProperty maxValue = new SimpleIntegerProperty();

    public final int getMaxValue() {
        return this.maxValue.get();
    }

    public final void setMaxValue(int maxValue) {
        this.maxValue.set(maxValue);
    }

    public IntegerProperty maxValueProperty() {
        return this.maxValue;
    }

    private IntegerProperty minValue = new SimpleIntegerProperty();

    public final int getMinValue() {
        return this.minValue.get();
    }

    public final void setMinValue(int minValue) {
        this.minValue.set(minValue);
    }

    public IntegerProperty minValueProperty() {
        return this.minValue;
    }

    /////////// Public Methods //////////////////////////////////////////////////////////////

    @FXML
    public void decrement() {
        if (this.getDisplayedValue() <= this.getMaxValue() && this.getDisplayedValue() > this.getMinValue()) {
            int result = this.getDisplayedValue() - 1;
            this.setDisplayedValue(result);
        }
    }

    @FXML
    public void increment() {
        if (this.getDisplayedValue() < this.getMaxValue() && this.getDisplayedValue() >= this.getMinValue()) {
            int result = this.getDisplayedValue() + 1;
            this.setDisplayedValue(result);
        }
    }

    public void setLimiters(int min, int max) {
        if (min > max) {
            this.setMaxValue(min);
            this.setMinValue(max);
            this.setTickUnits(min);
        } else {
            this.setMaxValue(max);
            this.setMinValue(min);
            this.setTickUnits(max);
        }
    }

    /////////// Private Methods /////////////////////////////////////////////////////////////

    private void setTickUnits(int maxVal) {
        int tickUnit = maxVal / 3;
        this.adjustment.setMajorTickUnit((tickUnit != 0) ? Math.abs(tickUnit) : 1);
    }

    /////////// Protected Methods ///////////////////////////////////////////////////////////

    @Override
    protected void setBindings() {
        this.value.textProperty().bindBidirectional(this.displayedValueProperty(), new NumberStringConverter(NumberFormat.getNumberInstance()));
        this.adjustment.maxProperty().bindBidirectional(this.maxValueProperty());
        this.adjustment.minProperty().bindBidirectional(this.minValueProperty());
        this.adjustment.valueProperty().bindBidirectional(this.displayedValueProperty());
    }

    @Override
    protected void setDefaults() {
        this.setLimiters(SLIDER_MIN_DEFAULT, SLIDER_MAX_DEFAULT);
        this.setDisplayedValue(SLIDER_MIN_DEFAULT);
        this.adjustment.setShowTickMarks(true);
        this.adjustment.setShowTickLabels(true);
    }

    @Override
    protected void setEvents() {

    }

    @Override
    protected void setListeners() {

    }

}
