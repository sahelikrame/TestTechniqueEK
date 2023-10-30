package org.ekwateur.domain.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnergyTest {
    @Test
    public void testElectricity() {
        Energy energy = Energy.Electricity;
        assertEquals("Electricity", energy.toString());
    }

    @Test
    public void testGas() {
        Energy energy = Energy.Gas;
        assertEquals("Gas", energy.toString());
    }
}