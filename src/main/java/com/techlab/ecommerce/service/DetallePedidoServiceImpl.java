package com.techlab.ecommerce.service;

import com.techlab.ecommerce.model.DetallePedido;
import com.techlab.ecommerce.repository.DetallePedidoRepository;
import com.techlab.ecommerce.excepciones.DetallePedidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

    private final DetallePedidoRepository detallePedidoRepository;

    @Autowired
    public DetallePedidoServiceImpl(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @Override
    public DetallePedido obtenerPorId(Long id) {
        return detallePedidoRepository.findById(id)
                .orElseThrow(() -> new DetallePedidoException("Detalle de pedido no encontrado con ID: " + id));
    }

    @Override
    public List<DetallePedido> listarTodos() {
        return detallePedidoRepository.findAll();
    }

    @Override
    public DetallePedido actualizar(Long id, DetallePedido detalleActualizado) {
        DetallePedido detalle = obtenerPorId(id);
        detalle.setCantidad(detalleActualizado.getCantidad());
        detalle.setPrecio(detalleActualizado.getPrecio());
        detalle.setProducto(detalleActualizado.getProducto());
        detalle.setPedido(detalleActualizado.getPedido());
        return detallePedidoRepository.save(detalle);
    }

    @Override
    public void eliminar(Long id) {
        detallePedidoRepository.deleteById(id);
    }

    @Override
    public DetallePedido guardar(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    @Override
    public List<DetallePedido> listarPorPedidoId(Long pedidoId) {
        return detallePedidoRepository.findByPedidoId(pedidoId);
    }
}
