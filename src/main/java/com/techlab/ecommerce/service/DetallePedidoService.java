package com.techlab.ecommerce.service;

import com.techlab.ecommerce.model.DetallePedido;

import java.util.List;

public interface DetallePedidoService {
    DetallePedido obtenerPorId(Long id);
    List<DetallePedido> listarTodos();
    DetallePedido actualizar(Long id, DetallePedido detalleActualizado);
    void eliminar(Long id);
    DetallePedido guardar(DetallePedido detallePedido);
    List<DetallePedido> listarPorPedidoId(Long pedidoId);
}
