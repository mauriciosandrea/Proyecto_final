package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.model.DetallePedido;
import com.techlab.ecommerce.service.DetallePedidoService;
import com.techlab.ecommerce.excepciones.DetallePedidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles-pedido")
@CrossOrigin(origins = "*")
public class DetallePedidoController {

    private final DetallePedidoService detallePedidoService;

    public DetallePedidoController(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }

    @PostMapping
    public ResponseEntity<DetallePedido> crearDetallePedido(@RequestBody DetallePedido detallePedido) {
        DetallePedido nuevoDetalle = detallePedidoService.guardar(detallePedido);
        return new ResponseEntity<>(nuevoDetalle, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> obtenerPorId(@PathVariable Long id) {
        DetallePedido detalle = detallePedidoService.obtenerPorId(id);
        return new ResponseEntity<>(detalle, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DetallePedido>> listarTodos() {
        List<DetallePedido> detalles = detallePedidoService.listarTodos();
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> actualizar(@PathVariable Long id, @RequestBody DetallePedido detalleActualizado) {
        DetallePedido actualizado = detallePedidoService.actualizar(id, detalleActualizado);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        detallePedidoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
