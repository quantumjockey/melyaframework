package com.quantumjockey.melya.action;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.concurrent.Callable;

/*
 Generic typing syntax interpreted from the tutorial article:
 http://docs.oracle.com/javase/tutorial/java/generics/types.html
 as accessed on 10/19/2014.
 */

public class ActionViewModel<T> {

    /////////// Constants ///////////////////////////////////////////////////////////////////

    public final String DEFAULT_ID = "Action";

    /////////// Fields //////////////////////////////////////////////////////////////////////

    private Callable<T> action;

    /////////// Properties //////////////////////////////////////////////////////////////////

    private StringProperty identifier = new SimpleStringProperty();

    public final String getIdentifier() {
        return this.identifier.get();
    }

    public final void setIdentifier(String identifier) {
        this.identifier.set(identifier);
    }

    public StringProperty identifierProperty() {
        return this.identifier;
    }

    /////////// Constructors ////////////////////////////////////////////////////////////////

    public ActionViewModel(String id, Callable<T> action) {
        this.action = action;
        this.generateIdentifier(id);
    }

    /////////// Public Methods //////////////////////////////////////////////////////////////

    public void invoke() {
        try {
            this.action.call();
        } catch (Exception e) {
            if (e.getClass() == NullPointerException.class)
                System.out.println("Action for ViewModel '" + this.getIdentifier() + "' was not properly initialized.");
            else {
                System.out.println("Action for ViewModel '" + this.getIdentifier() + "' could not be invoked.");
                e.printStackTrace();
            }
        }
    }

    /////////// Private Methods /////////////////////////////////////////////////////////////

    private void generateIdentifier(String id){
        if (id == null)
            this.setIdentifier(this.DEFAULT_ID);
        else
            this.setIdentifier(id);
    }

}
