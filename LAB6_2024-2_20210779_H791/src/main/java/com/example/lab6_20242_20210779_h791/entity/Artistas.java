package com.example.lab6_20242_20210779_h791.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "artistas")
public class Artistas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artistaId", nullable = false)
    private Integer artistaId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "genero")
    private String genero;

    @Column(name = "telefono")
    private String telefono;
}
