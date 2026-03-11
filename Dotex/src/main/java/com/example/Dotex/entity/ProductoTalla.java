package com.example.Dotex.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "producto_talla")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoTalla {

    @EmbeddedId
    private ProductoTallaId id; // Tenemos un primary key compuesta (id_producto, id_talla) y creamos este atributo.

    @Column(name = "stock")
    private Integer stock;
    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto")
    private Producto producto;
    @ManyToOne
    @MapsId("id_talla")
    @JoinColumn(name = "id_talla")
    private Talla talla;
}

