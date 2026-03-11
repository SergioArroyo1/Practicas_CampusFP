package com.example.Dotex.repository;

import com.example.Dotex.entity.ProductoTalla;
import com.example.Dotex.entity.ProductoTallaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoTallaRepository extends JpaRepository<ProductoTalla, ProductoTallaId> {

    // Buscar todas las tallas de un producto
    List<ProductoTalla> findByProductoIdProducto(Integer idProducto);

    // Buscar todos los productos de una talla especifica
    List<ProductoTalla> findByTallaIdTalla(Integer idTalla);

    // Buscar un stock especifico de un producto y talla
    ProductoTalla findByProductoIdProductoAndTallaIdTalla(Integer idProducto, Integer idTalla);
}
