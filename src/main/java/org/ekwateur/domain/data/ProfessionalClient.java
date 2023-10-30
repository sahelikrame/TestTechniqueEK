package org.ekwateur.domain.data;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.ekwateur.domain.data.Client;

public final class ProfessionalClient extends Client {
    private String siretNumber;
    private String companyName;
    private double salesRevenue;

    public ProfessionalClient(String clientReference, String siretNumber, String companyName, double salesRevenue) {
        super(clientReference);
        validateClientReference(clientReference);
        this.siretNumber = siretNumber;
        this.companyName = companyName;
        this.salesRevenue = salesRevenue;
    }

    public ProfessionalClient() {

    }

    public double getSalesRevenue() {
        return salesRevenue;
    }

    @Override
    public String toString() {
        return "ProfessionalClient{" +
                "siretNumber='" + siretNumber + '\'' +
                ", companyName='" + companyName + '\'' +
                ", salesRevenue=" + salesRevenue +
                '}';
    }

    public String getSiretNumber() {
        return siretNumber;
    }

    public String getCompanyName() {
        return companyName;
    }
}