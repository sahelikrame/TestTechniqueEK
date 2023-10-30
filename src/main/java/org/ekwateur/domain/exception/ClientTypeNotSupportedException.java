package org.ekwateur.domain.exception;

public class ClientTypeNotSupportedException extends RuntimeException {
    public ClientTypeNotSupportedException() {
        super("Le type de client n'est pas reconnu");
    }
}
