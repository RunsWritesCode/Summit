package com.example.codeclan.summit;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by sophiemullins on 07/01/2018.
 */

public class SummitTest {

    Summit summit;

    @Before
    public void before() {
        summit = new Summit("Ben Nevis", 1345, "Grampian Mountains", "Scotland");
    }

    @Test
    public void getNameTest() {
        assertEquals("Ben Nevis", summit.getName());
    }

    @Test
    public void getHeightTest() {
        assertEquals("1345", summit.getHeight());
    }

    @Test
    public void getRangeTest() {
        assertEquals("Grampian Mountains", summit.getRange());
    }

    @Test
    public void getCountryTest() {
        assertEquals("Scotland", summit.getCountry());
    }

}
