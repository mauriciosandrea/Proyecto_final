package com.techlab.ecommerce.service;

import com.techlab.ecommerce.excepciones.ProductoNoEncontradoException;
import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

        @Override
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto actualizar(Producto producto) {
        Producto existente = productoRepository.findById(producto.getId())
                .orElseThrow(() -> new ProductoNoEncontradoException(producto.getId()));
        // Actualizar campos
        existente.setNombre(producto.getNombre());
        existente.setDescripcion(producto.getDescripcion());
        existente.setPrecio(producto.getPrecio());
        existente.setStock(producto.getStock());
        return productoRepository.save(existente);
    }


}
