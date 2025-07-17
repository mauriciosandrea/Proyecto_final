package com.techlab.ecommerce.excepciones;

public class PedidoException extends RuntimeException {
    public PedidoException(String mensaje) {
        super(mensaje);
    }
}
