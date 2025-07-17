package com.techlab.ecommerce.excepciones;

public class ProductoException extends RuntimeException {
    public ProductoException(String mensaje) {
        super(mensaje);
    }
}
