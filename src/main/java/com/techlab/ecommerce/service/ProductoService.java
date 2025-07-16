package com.techlab.ecommerce.service;

import com.techlab.ecommerce.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listarTodos();
    Optional<Producto> buscarPorId(Long id);
    List<Producto> buscarPorNombre(String nombre);
    Producto guardar(Producto producto);
    Producto actualizar(Producto producto);
    void eliminar(Long id);
}
