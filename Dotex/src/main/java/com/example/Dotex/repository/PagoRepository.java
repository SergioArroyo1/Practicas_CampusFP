package com.example.Dotex.repository;

import com.example.Dotex.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    // Buscar todos los pagos de un pedido
    List<Pago> findByPedidoIdPedido(Integer idPedido);

    // Buscar pagos por estado
    List<Pago> findByEstado(String estado);

    // Buscar pagos por metodo de pago
    List<Pago> findByMetodoPago(String metodoPago);

    // Buscar pagos entre fechas
    List<Pago> findByFechaPagoBetween(LocalDate inicio, LocalDate fin);
}
