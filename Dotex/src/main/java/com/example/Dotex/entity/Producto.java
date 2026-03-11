package com.example.Dotex.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    @Column(name = "nombre", nullable=false,length=150)
    private String nombre;
    @Column (name = "tipo_prenda", length = 50)
    private String tipoPrenda;
    @Column(name="color", length=50)
    private String color;
    @Column(name="precio", nullable = false,precision = 10, scale = 2)
    private BigDecimal precio;
    @Column(name="stock")
    private Integer stock;
    @ManyToOne
    @JoinColumn(name = "id_categoria",nullable = false)
    private Categoria categoria;
    @OneToMany(mappedBy = "producto", fetch=FetchType.LAZY)
    private List<DetallePedido> detalles;

}