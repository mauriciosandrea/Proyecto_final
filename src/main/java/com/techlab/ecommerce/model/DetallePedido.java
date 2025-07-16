package com.techlab.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_pedido")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private Integer cantidad;

    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}