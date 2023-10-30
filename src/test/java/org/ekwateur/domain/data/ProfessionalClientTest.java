package org.ekwateur.domain.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessionalClientTest {
    @Test
    public void testConstructorAndGetters() {
        String clientReference = "EKW87654321";
        String siretNumber = "1234567890";
        String companyName = "Ekwateur Entreprises";
        double salesRevenue = 1500000.0;

        ProfessionalClient client = new ProfessionalClient(clientReference, siretNumber, companyName, salesRevenue);

        assertEquals(clientReference, client.getClientReference());
        assertEquals(siretNumber, client.getSiretNumber());
        assertEquals(companyName, client.getCompanyName());
        assertEquals(salesRevenue, client.getSalesRevenue(), 0.01); // Utilisation d'une tolérance pour les valeurs double
    }

    @Test
    public void testToString() {
        ProfessionalClient client = new ProfessionalClient("EKW87654321", "1234567890", "Ekwateur Entreprises", 1500000.0);
        assertEquals("ProfessionalClient{siretNumber='1234567890', companyName='Ekwateur Entreprises', salesRevenue=1500000.0}", client.toString());
    }
}