package org.ekwateur.domain.data;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.ekwateur.domain.data.Client;
import org.springframework.stereotype.Component;

public final class ParticularClient extends Client {
    private String title;
    private String lastName;
    private String firstName;

    public ParticularClient(String clientReference, String title, String lastName, String firstName) {
        super(clientReference);
        validateClientReference(clientReference);
        this.title = title;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public ParticularClient() {
    }

    @Override
    public String toString() {
        return "ParticularClient{" +
                "title='" + title + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
