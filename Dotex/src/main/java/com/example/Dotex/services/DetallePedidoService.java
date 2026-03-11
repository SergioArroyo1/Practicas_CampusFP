package com.example.Dotex.services;

import com.example.Dotex.entity.DetallePedido;
import com.example.Dotex.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    public List<DetallePedido> verDetallesPedido(int idPedido) {
        return detallePedidoRepository.findByPedidoIdPedido(idPedido);
    }
    public List<DetallePedido> verDetallesProducto(int idProducto) {
        return detallePedidoRepository.findByProductoIdProducto(idProducto);
    }
    public List<DetallePedido> buscarDetallePorPedidoYProducto(int idPedido, int idProducto) {
        return Collections.singletonList(detallePedidoRepository.findByPedidoIdPedidoAndProductoIdProducto(idPedido, idProducto));
    }
}