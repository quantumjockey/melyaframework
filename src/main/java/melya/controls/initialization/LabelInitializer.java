package melya.controls.initialization;

import com.quantumjockey.mvvmbase.controls.initialization.base.ControlInitializer;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;

public class LabelInitializer extends ControlInitializer<Label> {

    /////////// Constructors ////////////////////////////////////////////////////////////////

    public LabelInitializer(Label label) {
        super(label);
    }

    /////////// Public Methods //////////////////////////////////////////////////////////////

    public void update(String text, String tooltip) {
        this.markupReference.setText(text);
        this.setTooltip(tooltip);
    }

    /////////// Private Methods /////////////////////////////////////////////////////////////

    private void setTooltip(String _tooltip) {
        if (_tooltip != null && !_tooltip.equals(""))
            this.markupReference.setTooltip(new Tooltip(_tooltip));
    }

}
