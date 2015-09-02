package com.quantumjockey.melya.icons;

import javafx.scene.image.Image;

/*
 * As of 11/22/2014, images have been taken from the "Silk" icon theme images by Mark James via Wikimedia Commons
 * Links to these include, in no particular order:
 * Directory Without Data Icon: http://commons.wikimedia.org/wiki/File:Folder-silk.png
 * Data Image Icon: http://commons.wikimedia.org/wiki/File:Folder_image.png
 * Data Group Icon: http://commons.wikimedia.org/wiki/File:Folder_database.png
 *
 * As of 4/14/2015, additional images have been taken from the Gnome project image set via Wikimedia Commons
 * Links to these include, in no particular order:
 * Invert/Flip Icon: https://commons.wikimedia.org/wiki/File:View-refresh-2.svg
 * Rotate Left Icon: https://commons.wikimedia.org/wiki/File:Gnome-object-rotate-left.svg
 * Rotate Right Icon: https://commons.wikimedia.org/wiki/File:Gnome-object-rotate-right.svg
 *
 * Note: Class.getResourceAsStream() path string arguments must be formatted relative to Sources Root to avoid null value retrieval.
 */

public class IconLibrary {

    /////////// Fields //////////////////////////////////////////////////////////////////////

    private final String basePath = "/images/";

    private final String folderIcon = this.basePath + "empty_folder.png";
    private final String groupIcon = this.basePath + "image_group.png";
    private final String invertIcon = this.basePath + "invert.png";
    private final String rootIcon = this.basePath + "data_group.png";
    private final String rotateLeftIcon = this.basePath + "rotate_left.png";
    private final String rotateRightIcon = this.basePath + "rotate_right.png";

    private int size;

    /////////// Accessors ///////////////////////////////////////////////////////////////////

    public Image getFolderIcon() {
        return this.getResourceImage(this.folderIcon, this.size);
    }

    public Image getGroupIcon() {
        return this.getResourceImage(this.groupIcon, this.size);
    }

    public Image getInvertIcon() {
        return this.getResourceImage(this.invertIcon, this.size);
    }

    public Image getRootIcon() {
        return this.getResourceImage(this.rootIcon, this.size);
    }

    public Image getRotateLeftIcon() {
        return this.getResourceImage(this.rotateLeftIcon, this.size);
    }

    public Image getRotateRightIcon() {
        return this.getResourceImage(this.rotateRightIcon, this.size);
    }

    /////////// Constructor(s) //////////////////////////////////////////////////////////////

    public IconLibrary(int size) {
        this.size = size;
    }

    public IconLibrary() {
        this(16);
    }

    /////////// Private Methods /////////////////////////////////////////////////////////////

    private Image getResourceImage(String path, int size) {
        return new Image(this.getClass().getResourceAsStream(path), size, size, true, true);
    }

}
