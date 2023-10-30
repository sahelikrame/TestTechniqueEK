package org.ekwateur.domain.data;

import org.ekwateur.domain.exception.ClientTypeNotSupportedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    @Test
    public void testValidClientReference() {
        Client client = new ParticularClient("EKW12345678","M.", "Defraine", "Anthony");
        assertEquals("EKW12345678", client.getClientReference());
    }

    @Test
    public void testToString() {
        Client client = new ParticularClient("EKW12345678","M.", "Defraine", "Anthony");
        assertEquals("ParticularClient{title='M.', lastName='Defraine', firstName='Anthony'}", client.toString());
    }
}