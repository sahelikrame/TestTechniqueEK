package org.ekwateur.domain.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

public sealed abstract class Client permits ParticularClient, ProfessionalClient{

    @Pattern(regexp = "EKW\\d{8}",message = "Le format doit être 'EKW' suivi de 8 caractères numériques")
    private String clientReference;

    public Client(String clientReference) {
        this.clientReference = clientReference;
    }

    public Client() {

    }

    public String getClientReference() {
        return clientReference;
    }
    protected void validateClientReference(String clientReference) {
        if (!clientReference.matches("EKW\\d{8}")) {
            throw new IllegalArgumentException("Le format de la référence du client est incorrect.");
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientReference='" + clientReference + '\'' +
                '}';
    }
}
