package org.ekwateur.domain.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticularClientTest {
    @Test
    public void testConstructorAndGetters() {
        String clientReference = "EKW12345678";
        String title = "Mr.";
        String lastName = "Doe";
        String firstName = "John";

        ParticularClient client = new ParticularClient(clientReference, title, lastName, firstName);

        assertEquals(clientReference, client.getClientReference());
        assertEquals(title, client.getTitle());
        assertEquals(lastName, client.getLastName());
        assertEquals(firstName, client.getFirstName());
    }

    @Test
    public void testToString() {
        ParticularClient client = new ParticularClient("EKW12345678", "Mr.", "Doe", "John");
        assertEquals("ParticularClient{title='Mr.', lastName='Doe', firstName='John'}", client.toString());
    }
}