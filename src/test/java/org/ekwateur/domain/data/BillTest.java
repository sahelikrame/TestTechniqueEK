package org.ekwateur.domain.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BillTest {

    private Bill bill;
    private Date date;
    private double totalCost;
    private Client client;

    @BeforeEach
    public void setUp() {
        bill = new Bill();
        date = new Date();
        totalCost = 100.0;
        client = new ParticularClient("EKW12345678", "M.", "Defraine", "Anthony");
    }

    @Test
    public void testSetDate() {
        bill.setDate(date);
        assertEquals(date, bill.getDate());
    }

    @Test
    public void testSetTotalCost() {
        bill.setTotalCost(totalCost);
        assertEquals(totalCost, bill.getTotalCost(), 0.01); // Utilisation d'une tolérance pour les valeurs double
    }

    @Test
    public void testSetClient() {
        bill.setClient(client);
        assertEquals(client, bill.getClient());
    }
}