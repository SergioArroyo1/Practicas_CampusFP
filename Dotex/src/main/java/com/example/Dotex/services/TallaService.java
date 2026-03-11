package com.example.Dotex.services;

import com.example.Dotex.entity.Talla;
import com.example.Dotex.repository.TallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TallaService {
    @Autowired
    private TallaRepository tallaRepository;
    public List<Talla> verTallas() {
        return tallaRepository.findAllTallas();
    }
    public Optional<Talla> buscarTallas(String nombre) {
        return tallaRepository.findByNombre(nombre);
    }
    public boolean comprobarTallaPorNombre(String nombre) {
        return tallaRepository.existsByNombre(nombre);
    }
}