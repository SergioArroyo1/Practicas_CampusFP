package com.example.Dotex.repository;

import com.example.Dotex.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT usuario FROM Usuario usuario WHERE usuario.email = :correo")
    Optional<Usuario> findUsuarioByEmail(@Param("correo") String email);
}