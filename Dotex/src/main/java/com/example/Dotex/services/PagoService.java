package com.example.Dotex.services;

import com.example.Dotex.entity.Pago;
import com.example.Dotex.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;
    public List<Pago> buscarPagoPorPedido(int idPedido) {
        return pagoRepository.findByPedidoIdPedido(idPedido);
    }
    public List<Pago> buscarPagoPorEstado(String estado) {
        return pagoRepository.findByEstado(estado);
    }
    public List<Pago> buscarPagosPorMetodo(String metodoPago) {
        return pagoRepository.findByMetodoPago(metodoPago);
    }
    public List<Pago> buscarPagosPorFecha(LocalDate inicio, LocalDate fin) {
        return pagoRepository.findByFechaPagoBetween(inicio, fin);
    }
}