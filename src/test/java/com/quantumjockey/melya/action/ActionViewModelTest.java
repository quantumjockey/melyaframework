package com.quantumjockey.melya.action;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActionViewModelTest {

    /////////// Fields //////////////////////////////////////////////////////////////////////

    ActionViewModel<Void> manaMana;

    /////////// Setup/Teardown //////////////////////////////////////////////////////////////

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    /////////// Tests ///////////////////////////////////////////////////////////////////////

    @Test
    public void IdentifierProperty_Null_InsertDefaultID() {
        this.manaMana = new ActionViewModel<>(null, () -> {
            System.out.println("Doing important stuff here!");
            return null;
        });
        Assert.assertSame(this.manaMana.DEFAULT_ID, this.manaMana.getIdentifier());
    }

}
