package com.example.Dotex.services;

import com.example.Dotex.entity.Usuario;
import com.example.Dotex.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public Optional<Usuario> buscarUsuarioPorEmail(String email)  {
        return usuarioRepository.findUsuarioByEmail(email);
    }
}