package com.example.Dotex.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoTallaId implements Serializable {
    @Column(name = "id_producto")
    private Integer idProducto;
    @Column(name = "id_talla")
    private Integer idTalla;
}