package com.example.Dotex.repository;

import com.example.Dotex.entity.Talla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TallaRepository extends JpaRepository<Talla, Integer> {
    @Query("SELECT t FROM Talla t")
    List<Talla> findAllTallas();

    // buscar talla por nombre
    Optional<Talla> findByNombre(String nombre);

    // comprobar si existe una talla
    boolean existsByNombre(String nombre);
}
