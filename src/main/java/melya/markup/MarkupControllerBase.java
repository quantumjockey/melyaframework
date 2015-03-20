package melya.markup;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class MarkupControllerBase implements Initializable {

    /////////// Constructors //////////////////////////////////////////////////////////////////

    public MarkupControllerBase() {
        this.createCustomControls();
    }

    /////////// Public Methods ////////////////////////////////////////////////////////////////

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.setBindings();
        this.setDefaults();
        this.setEvents();
        this.setListeners();
    }

    /////////// Protected Methods /////////////////////////////////////////////////////////////

    protected abstract void createCustomControls();

    protected abstract void setBindings();

    protected abstract void setDefaults();

    protected abstract void setEvents();

    protected abstract void setListeners();

}
