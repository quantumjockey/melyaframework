package melya.controls.selectormeta;

import javafx.scene.image.Image;

public class SelectableCategory {

    /////////// Fields //////////////////////////////////////////////////////////////////////

    private Image icon;
    private String tag;

    /////////// Accessors ///////////////////////////////////////////////////////////////////

    public Image getIcon() {
        return this.icon;
    }

    public String getTag() {
        return this.tag;
    }

    /////////// Constructor(s) //////////////////////////////////////////////////////////////

    public SelectableCategory(String tag, Image icon) {
        this.icon = icon;
        this.tag = tag;
    }

}
