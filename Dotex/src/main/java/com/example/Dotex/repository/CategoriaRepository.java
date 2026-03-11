package com.example.Dotex.repository;
import com.example.Dotex.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Integer>{
    // Buscar categoría por nombre
    Optional<Categoria> findByNombreCategoria(String nombreCategoria);

    // Comprobar si existe alguna categoria
    boolean existsByNombreCategoria(String nombreCategoria);
}