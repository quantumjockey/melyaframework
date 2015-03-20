package melya.icons;

import javafx.scene.image.Image;

/*
 * As of 11/22/2014, images have been taken from the "Silk" icon theme images by Mark James via Wikimedia Commons
 * Links to these include, in order of field definition:
 * Directory Without Data Icon: http://commons.wikimedia.org/wiki/File:Folder-silk.png
 * Data Image Icon: http://commons.wikimedia.org/wiki/File:Folder_image.png
 * Data Group Icon: http://commons.wikimedia.org/wiki/File:Folder_database.png
 *
 * Note: Class.getResourceAsStream() path string arguments must be formatted relative to Sources Root to avoid null value retrieval.
 */

public class IconLibrary {

    /////////// Fields //////////////////////////////////////////////////////////////////////

    private final Image folderIcon = new Image(getClass().getResourceAsStream("/com/quantumjockey/mvvmbase/icons/images/empty_folder.png"));
    private final Image groupIcon = new Image(getClass().getResourceAsStream("/com/quantumjockey/mvvmbase/icons/images/image_group.png"));
    private final Image rootIcon = new Image(getClass().getResourceAsStream("/com/quantumjockey/mvvmbase/icons/images/data_group.png"));

    /////////// Accessors ///////////////////////////////////////////////////////////////////

    public Image getFolderIcon() {
        return this.folderIcon;
    }

    public Image getGroupIcon() {
        return this.groupIcon;
    }

    public Image getRootIcon() {
        return this.rootIcon;
    }

}
