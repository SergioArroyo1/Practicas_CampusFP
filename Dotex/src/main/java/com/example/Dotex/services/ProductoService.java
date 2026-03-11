package com.example.Dotex.services;

import com.example.Dotex.entity.Producto;
import com.example.Dotex.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    public List<Producto> verProductos() {
        return productoRepository.findAll();
    }
    public List<Producto> buscarProductosPorTipo(String tipoPrenda) {
        return productoRepository.findProductosByTipoPrenda(tipoPrenda);
    }
}