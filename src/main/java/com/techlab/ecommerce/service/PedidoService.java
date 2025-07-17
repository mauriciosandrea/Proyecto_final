package com.techlab.ecommerce.service;

import com.techlab.ecommerce.model.Pedido;
import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> listar();
    Optional<Pedido> buscarPorId(Long id);
    Pedido guardar(Pedido pedido);
    void eliminar(Long id);
    List<Pedido> buscarPorClienteId(Long clienteId);
}
