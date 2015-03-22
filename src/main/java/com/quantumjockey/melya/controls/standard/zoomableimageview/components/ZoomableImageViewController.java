package com.quantumjockey.melya.controls.standard.zoomableimageview.components;

import com.quantumjockey.melya.controls.standard.doubleadjuster.DoubleAdjuster;
import com.quantumjockey.melya.delegateinterfaces.Func;
import com.quantumjockey.melya.markup.MarkupControllerBase;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.io.IOException;

public class ZoomableImageViewController extends MarkupControllerBase {

    /////////// Constants ///////////////////////////////////////////////////////////////////

    private final double AUTO_ZOOM_INCREMENT = 0.5;
    private final double DEFAULT_ZOOM_MAX = 6.0;

    /////////// Fields //////////////////////////////////////////////////////////////////////

    @FXML
    private ImageView imageViewport;

    @FXML
    private DoubleAdjuster imageZoom;

    @FXML
    private Label pixelTrack;

    @FXML
    private ScrollPane scrollViewport;

    private Image cachedImage;
    private Func<String, Integer, Integer> captionAppendageWithYXArguments;

    /////////// Accessors ///////////////////////////////////////////////////////////////////

    public ImageView getImageViewport() {
        return this.imageViewport;
    }

    public Label getPixelTrack() {
        return pixelTrack;
    }

    public ScrollPane getScrollViewport() {
        return scrollViewport;
    }

    /////////// Properties //////////////////////////////////////////////////////////////////

    private DoubleProperty maxZoom = new SimpleDoubleProperty();

    public final double getMaxZoom() {
        return this.maxZoom.get();
    }

    public final void setMaxZoom(double maxZoom) {
        this.maxZoom.set(maxZoom);
    }

    public DoubleProperty maxZoomProperty() {
        return this.maxZoom;
    }

    private DoubleProperty minZoom = new SimpleDoubleProperty();

    public final double getMinZoom() {
        return this.minZoom.get();
    }

    public final void setMinZoom(double zoomLevel) {
        this.minZoom.set(zoomLevel);
    }

    public DoubleProperty minZoomProperty() {
        return this.minZoom;
    }

    private DoubleProperty zoomLevel = new SimpleDoubleProperty();

    public final double getZoomLevel() {
        return this.zoomLevel.get();
    }

    public final void setZoomLevel(double zoomLevel) {
        this.zoomLevel.set(zoomLevel);
    }

    public DoubleProperty zoomLevelProperty() {
        return this.zoomLevel;
    }

    /////////// Public Methods //////////////////////////////////////////////////////////////

    public void addToCaption(Func<String, Integer, Integer> appendage){
        this.captionAppendageWithYXArguments = appendage;
    }

    public void render(Image image) throws IOException {
        if (image != null) {
            this.cachedImage = image;
            this.getImageViewport().setSmooth(false);
            this.getImageViewport().setImage(image);
            this.updateZoomScale(image);
        }
    }

    public void setZoomBounds(double min, double max) {
        double maxVal = (max <= 0) ? this.DEFAULT_ZOOM_MAX : max;
        double minVal = (min < 0) ? 0 : min;
        this.imageZoom.getController().setLimiters(minVal, maxVal);
    }

    public void setZoomIncrement(double increment) {
        double incrementVal = (increment <= 0) ? this.AUTO_ZOOM_INCREMENT : increment;
        this.imageZoom.getController().setIncrement(incrementVal);
    }

    /////////// Private Methods /////////////////////////////////////////////////////////////

    private void autoZoomViewport(MouseEvent event) {
        if (this.cachedImage != null && event.getClickCount() == 2) {
            double currentZoom = this.getZoomLevel();
            double max = this.getMaxZoom();
            double min = this.getMinZoom();
            if (event.getButton() == MouseButton.SECONDARY) {
                double newValue = currentZoom - this.AUTO_ZOOM_INCREMENT;
                this.setZoomLevel((newValue < min) ? min : newValue);
            } else {
                double newValue = currentZoom + this.AUTO_ZOOM_INCREMENT;
                this.setZoomLevel((newValue > max) ? max : newValue);
            }
        }
    }

    private void clearPixelDescriptor(MouseEvent event) {
        this.getPixelTrack().setText("");
    }

    private void displayActivePixel(MouseEvent event) {
        if (this.cachedImage != null) {
            double imageX = this.cachedImage.getWidth();
            double realX = event.getX();
            double viewportX = this.getImageViewport().getFitWidth();
            int scaledX = (int) ((realX / viewportX) * imageX);

            double imageY = this.cachedImage.getHeight();
            double realY = event.getY();
            double viewportY = this.getImageViewport().getFitHeight();
            int scaledY = (int) ((realY / viewportY) * imageY);

            int scaledYFlipped = ((int) imageY - scaledY);

            // (imageY - scaledY) used for display to represent 0,0 in bottom-left corner of image
            String activeCoordinatesLabel = ((this.getZoomLevel() < 1) ? "[Approximate] " : "")
                    + "Coordinates (x,y): " + scaledX + "," + scaledYFlipped
                    + ((captionAppendageWithYXArguments != null) ? " - " + captionAppendageWithYXArguments.call(scaledYFlipped, scaledX) : "");

            String tooltip = ((this.getZoomLevel() < 1) ? "[Approx.] " : "")
                    + "(x,y): " + scaledX + "," + scaledYFlipped
                    + ((captionAppendageWithYXArguments != null) ? System.getProperty("line.separator") + captionAppendageWithYXArguments.call(scaledYFlipped, scaledX) : "");

            this.getPixelTrack().setText(activeCoordinatesLabel);
            this.getScrollViewport().setTooltip(new Tooltip(tooltip));
        }
    }

    private void resizeImageView(Number newValue) {
        if (this.cachedImage != null) {
            double vVal = this.getScrollViewport().getVvalue();
            double hVal = this.getScrollViewport().getHvalue();
            double height = this.cachedImage.getHeight();
            double heightScaled = newValue.doubleValue() * height;
            double width = this.cachedImage.getWidth();
            double widthScaled = newValue.doubleValue() * width;
            this.getImageViewport().setFitHeight(heightScaled);
            this.getImageViewport().setFitWidth(widthScaled);
            this.getScrollViewport().setVvalue(vVal);
            this.getScrollViewport().setHvalue(hVal);
        }
    }

    private void setZoomDefaults() {
        double increment = 0.05;
        this.setZoomBounds(increment, 2.0);
        this.setZoomIncrement(increment);
        this.setZoomLevel(1.0);
    }

    private void updateZoomScale(Image image) {
        if (image != null) {
            double size = (image.getHeight() >= image.getWidth()) ? image.getHeight() : image.getWidth();
            double viewportSize = this.getScrollViewport().getWidth() - 2;
            double scale = viewportSize / size;
            this.setZoomBounds(scale, this.DEFAULT_ZOOM_MAX);
            this.setZoomLevel(scale);
        }
    }

    /////////// Protected Methods ///////////////////////////////////////////////////////////

    @Override
    protected void setBindings() {
        zoomLevelProperty().bindBidirectional(this.imageZoom.getController().displayedValueProperty());
        maxZoomProperty().bindBidirectional(this.imageZoom.getController().maxValueProperty());
        minZoomProperty().bindBidirectional(this.imageZoom.getController().minValueProperty());
    }

    @Override
    protected void setDefaults() {
        this.getPixelTrack().setFont(Font.font(null, FontWeight.BOLD, 13));
        this.setZoomDefaults();
    }

    @Override
    protected void setEvents() {

        EventHandler<MouseEvent> clickEvent = this::autoZoomViewport;
        EventHandler<MouseEvent> exitEvent = this::clearPixelDescriptor;
        EventHandler<MouseEvent> movedEvent = this::displayActivePixel;

        this.getImageViewport().setOnMouseClicked(clickEvent);
        this.getImageViewport().setOnMouseExited(exitEvent);
        this.getImageViewport().setOnMouseMoved(movedEvent);
    }

    @Override
    protected void setListeners() {

        ChangeListener<Number> onZoomChange = (observable, oldValue, newValue) -> this.resizeImageView(newValue);

        this.zoomLevelProperty().addListener(onZoomChange);
    }

}
