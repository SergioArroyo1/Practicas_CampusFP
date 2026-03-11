package com.example.Dotex.services;

import com.example.Dotex.entity.Pedido;
import com.example.Dotex.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    public List<Pedido> verPedidos() {
        return pedidoRepository.findAll();
    }
    public List<Pedido> buscarPedidosPorUsuario(String usuario) {
        return pedidoRepository.findPedidosByUsuario(usuario);
    }
    public List<Pedido> verPedidosPorEstado(String estado) {
        return pedidoRepository.findPedidosByEstado(estado);
    }
}