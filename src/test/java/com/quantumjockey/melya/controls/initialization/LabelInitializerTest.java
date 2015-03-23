package com.quantumjockey.melya.controls.initialization;

import javafx.scene.control.Label;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LabelInitializerTest {

    /////////// Fields //////////////////////////////////////////////////////////////////////

    Label mysteryLabel;
    LabelInitializer priorities;

    /////////// Setup/Teardown //////////////////////////////////////////////////////////////

    @Before
    public void setUp() throws Exception {
        // ALL the setup I should be doing.
    }

    @After
    public void tearDown() throws Exception {
        // ALL the teardown I should be doing.
    }

    /////////// Tests ///////////////////////////////////////////////////////////////////////

    @Test
    public void Constructor_NullObject_handleNullPointerException(){

    }

    @Test
    public void Update_NullText_GenerateTextDefault(){

    }

    @Test
    public void Update_NullTooltip_GenerateTooltipDefault(){

    }

}
