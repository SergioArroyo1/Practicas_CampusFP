package com.example.Dotex.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;


@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @Column(nullable = false, unique = true, length = 50)
    private String nombreRol;

    // Esta parte es opcional, sirve para tener la lista de usuarios de cada rol
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;
}