package melya.markup.scene.layout;

import com.quantumjockey.mvvmbase.markup.initialization.MarkupInitializer;
import com.quantumjockey.mvvmbase.markup.initialization.MarkupInitializerMacro;
import com.quantumjockey.mvvmbase.markup.scene.MarkupInitializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public abstract class HBoxComplement<GenericController> extends HBox implements MarkupInitializable<GenericController> {

    /////////// Fields //////////////////////////////////////////////////////////////////////

    private MarkupInitializer markupContainer;

    /////////// Constructors ////////////////////////////////////////////////////////////////

    public HBoxComplement() {
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
