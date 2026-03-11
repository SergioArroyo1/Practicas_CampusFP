package com.example.Dotex.repository;

import com.example.Dotex.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query("SELECT producto FROM Producto producto")
    List<Producto> findAll();
    @Query("SELECT producto FROM Producto producto WHERE producto.tipoPrenda = :tipoProducto")
    List<Producto> findProductosByTipoPrenda(@Param("tipoProducto") String tipoPrenda);
}
