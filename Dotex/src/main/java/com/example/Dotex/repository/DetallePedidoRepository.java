package com.example.Dotex.repository;

import com.example.Dotex.entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {
    // Buscar todos los detalles de un pedido
    List<DetallePedido> findByPedidoIdPedido(Integer idPedido);

    // Buscar todos los detalles de un producto
    List<DetallePedido> findByProductoIdProducto(Integer idProducto);

    // Buscar un detalle específico por pedido y producto
    DetallePedido findByPedidoIdPedidoAndProductoIdProducto(Integer idPedido, Integer idProducto);
}
