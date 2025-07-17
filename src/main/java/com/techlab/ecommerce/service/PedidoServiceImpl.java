package com.techlab.ecommerce.service;

import com.techlab.ecommerce.model.Pedido;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.model.DetallePedido;
import com.techlab.ecommerce.repository.PedidoRepository;
import com.techlab.ecommerce.repository.ProductoRepository;
import com.techlab.ecommerce.excepciones.PedidoException;
import com.techlab.ecommerce.excepciones.ProductoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public Pedido guardar(Pedido pedido) {
        for (DetallePedido detalle : pedido.getDetalles()) {
            Producto producto = productoRepository.findById(detalle.getProducto().getId())
                    .orElseThrow(() -> new ProductoException("Producto no encontrado: ID " + detalle.getProducto().getId()));

            if (producto.getStock() < detalle.getCantidad()) {
                throw new ProductoException("Stock insuficiente para el producto: " + producto.getNombre());
            }

            producto.setStock(producto.getStock() - detalle.getCantidad());
            productoRepository.save(producto);

            detalle.setProducto(producto);
            detalle.setPedido(pedido);
        }

        return pedidoRepository.save(pedido);
    }

    @Override
    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoException("Pedido no encontrado: ID " + id));
        pedidoRepository.delete(pedido);
    }

    @Override
    public List<Pedido> buscarPorClienteId(Long clienteId) {
        return pedidoRepository.findAll().stream()
                .filter(p -> p.getCliente() != null && p.getCliente().getId().equals(clienteId))
                .collect(Collectors.toList());
    }
}
