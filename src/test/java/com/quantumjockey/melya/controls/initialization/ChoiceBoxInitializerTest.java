package com.quantumjockey.melya.controls.initialization;

import javafx.scene.control.ChoiceBox;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ChoiceBoxInitializerTest {

    /////////// Fields //////////////////////////////////////////////////////////////////////

    ArrayList<String> allTheChoices;
    ChoiceBox<String> mysteryBox;
    ChoiceBoxInitializer<String> priorities;

    /////////// Setup/Teardown //////////////////////////////////////////////////////////////

    @Before
    public void setUp() throws Exception {
        this.allTheChoices = new ArrayList<>();
        this.allTheChoices.add("Thing One");
        this.allTheChoices.add("Thing Two");
    }

    @After
    public void tearDown() throws Exception {
        // ALL the teardown I should be doing.
    }

    /////////// Tests ///////////////////////////////////////////////////////////////////////

    @Test
    public void Constructor_NullObject_handleNullPointerException() {

    }

    @Test
    public void Populate_ListArgumentNull_CreateEmptyList() {

    }

}
