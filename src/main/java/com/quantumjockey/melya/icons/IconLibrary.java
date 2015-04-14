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

    private final String basePath = "/com/quantumjockey/melya/icons/images/";

    private final Image folderIcon = this.getResourceImage(this.basePath + "empty_folder.png");
    private final Image groupIcon = this.getResourceImage(this.basePath + "image_group.png");
    private final Image invertIcon = this.getResourceImage(this.basePath + "invert.png");
    private final Image rootIcon = this.getResourceImage(this.basePath + "data_group.png");
    private final Image rotateLeftIcon = this.getResourceImage(this.basePath + "rotate_left.png");
    private final Image rotateRightIcon = this.getResourceImage(this.basePath + "rotate_right.png");

    /////////// Accessors ///////////////////////////////////////////////////////////////////

    public Image getFolderIcon() {
        return this.folderIcon;
    }

    public Image getGroupIcon() {
        return this.groupIcon;
    }

    public Image getInvertIcon() {
        return this.invertIcon;
    }

    public Image getRootIcon() {
        return this.rootIcon;
    }

    public Image getRotateLeftIcon() {
        return this.rotateLeftIcon;
    }

    public Image getRotateRightIcon() {
        return this.rotateRightIcon;
    }

    /////////// Private Methods /////////////////////////////////////////////////////////////

    private Image getResourceImage(String path) {
        return new Image(getClass().getResourceAsStream(path));
    }

}
