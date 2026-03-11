package com.example.Dotex.repository;

import com.example.Dotex.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    @Query("SELECT pedido.fecha, pedido.estado, pedido.total FROM Pedido pedido")
    List<Pedido> findAll();
    @Query("SELECT pedido.fecha, pedido.estado, pedido.total FROM Pedido pedido WHERE pedido.usuario = :nombreUsuario")
    List<Pedido> findPedidosByUsuario(@Param("nombreUsuario") String usuario);
    @Query("SELECT pedido.fecha, pedido.estado, pedido.total FROM Pedido pedido WHERE pedido.estado = :estadoPedido")
    List<Pedido> findPedidosByEstado(@Param("estado") String estado);
}