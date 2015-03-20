package melya.markup.scene.layout;

import com.quantumjockey.mvvmbase.markup.initialization.MarkupInitializer;
import com.quantumjockey.mvvmbase.markup.initialization.MarkupInitializerMacro;
import com.quantumjockey.mvvmbase.markup.scene.MarkupInitializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public abstract class VBoxComplement<GenericController> extends VBox implements MarkupInitializable<GenericController> {

    /////////// Fields //////////////////////////////////////////////////////////////////////

    private MarkupInitializer markupContainer;

    /////////// Constructors ////////////////////////////////////////////////////////////////

    public VBoxComplement() {
        this.initializeComponents();
        this.loadControl();
    }

    /////////// Public Methods //////////////////////////////////////////////////////////////

    @SuppressWarnings("unchecked")
    public GenericController getController() {
        return (GenericController) this.markupContainer.getController();
    }

    /////////// Protected Methods ///////////////////////////////////////////////////////////

    protected abstract void initializeComponents();

    protected void intializeMarkup(Node rootObject, Class controllerClass) {
        this.markupContainer = MarkupInitializerMacro.createInitializer(rootObject, controllerClass);
    }

    /////////// Private Methods /////////////////////////////////////////////////////////////

    private void loadControl() {
        this.markupContainer.load();
    }

}
