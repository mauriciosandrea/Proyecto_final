package com.techlab.ecommerce.excepciones;

public class ClienteException extends RuntimeException {
    public ClienteException(String mensaje) {
        super(mensaje);
    }
}
