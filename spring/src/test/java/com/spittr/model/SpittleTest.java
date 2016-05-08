package com.spittr.model;

import org.junit.Test;
import sun.security.provider.ConfigFile;

import java.util.Date;

import static org.junit.Assert.*;

public class SpittleTest {

    private long id = 4424L;
    private String message = "Tempest keep was merely a setback";
    private Date date = new Date();
    private double longtitude = 241.52D;
    private double lantitude = 241.52D;

    @Test
    public void testEquals() throws Exception {

        Spittle spittle1 = new Spittle(id, message, null);
        assertTrue(spittle1.equals(new Spittle(id, message, null)));
        assertFalse(spittle1.equals(new Spittle(id, "TKE", null)));

        Spittle spittle2 = new Spittle(id, message, date),
                spittle2eq = new Spittle(id, message, date);
        assertTrue(spittle2 != spittle2eq);
        assertTrue(spittle2.equals(new Spittle(id, message, date)));
        assertFalse(spittle2.equals(new Spittle(id, message, new Date(date.getTime() + 1))));

        spittle2.setLongitude(longtitude);
        assertFalse(spittle2.equals(spittle2eq));
        spittle2eq.setLongitude(longtitude);
        assertTrue(spittle2.equals(spittle2eq));

        spittle2.setLatitude(lantitude);
        assertFalse(spittle2.equals(spittle2eq));
        spittle2eq.setLatitude(lantitude);
        assertTrue(spittle2.equals(spittle2eq));

    }

    @Test
    public void testHashCode() throws Exception {
        Spittle spittle = new Spittle(id, message, null);
        int origSpittleHash = spittle.hashCode();

        Spittle spittleEq = new Spittle(id,message, null);
        assertFalse(spittle == spittleEq);
        assertEquals(origSpittleHash, spittleEq.hashCode());
    }

}