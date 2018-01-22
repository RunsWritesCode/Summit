package com.example.codeclan.summit;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by sophiemullins on 07/01/2018.
 */

public class SummitsTest {

    @Test
    public void getListTest() {
        Summits summits = new Summits();
        assertEquals(15, summits.getList().size());
    }

    @Test
    public void canDeleteSummit() {
        Summits summits = new Summits();
        assertEquals(15, summits.getList().size());
    }
}
