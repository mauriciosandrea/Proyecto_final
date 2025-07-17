package com.techlab.ecommerce.service;



import com.techlab.ecommerce.model.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente guardar(Cliente cliente);
    Cliente obtenerPorId(Long id);
    List<Cliente> listarTodos();
    Cliente actualizar(Long id, Cliente cliente);
    void eliminar(Long id);
}
