package org.horlogeberlinoise.lampe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LampeTest {

    @Test
    public void testLampeAllumee() {
        Lampe lampe = new LampeAllumee();
        assertEquals("Y", lampe.etat());
    }

    @Test
    public void testLampeEteinte() {
        Lampe lampe = new LampeEteinte();
        assertEquals("O", lampe.etat());
    }

    @Test
    public void testAffichageCouleurLampeAllumee() {
        Lampe lampe = new LampeAllumee();
        assertEquals("YELLOW", lampe.getColor().name());
    }

    @Test
    public void testAffichageCouleurLampeEteinte() {
        Lampe lampe = new LampeEteinte();
        assertEquals("OFF", lampe.getColor().name());
    }
}