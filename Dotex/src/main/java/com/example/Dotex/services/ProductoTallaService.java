package com.example.Dotex.services;

import com.example.Dotex.entity.ProductoTalla;
import com.example.Dotex.repository.ProductoTallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductoTallaService {
    @Autowired
    private ProductoTallaRepository productoTallaRepository;
    public List<ProductoTalla> buscarTallasPorproducto(int idProducto) {
        return productoTallaRepository.findByProductoIdProducto(idProducto);
    }
    public List<ProductoTalla> buscarTallasPorProducto(int idTalla) {
        return productoTallaRepository.findByTallaIdTalla(idTalla);
    }
    public List<ProductoTalla> buscarStockPorTalla(int idProducto, int idTalla) {
        return Collections.singletonList(productoTallaRepository.findByProductoIdProductoAndTallaIdTalla(idProducto, idTalla));
    }
}