package com.example.lab6_20242_20210779_h791.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

@Getter
@Setter
@Entity
@Table(name = "artistas")
public class Artistas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artistaId", nullable = false)
    private Integer artistaId;

    @NotBlank(message = "El nombre del artista es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotBlank(message = "El género es obligatorio")
    @Size(max = 50, message = "El género no debe exceder los 50 caracteres")
    @Column(name = "genero", nullable = false)
    private String genero;

    @NotBlank(message = "El número de teléfono es obligatorio")
    @Pattern(regexp = "\\d{9}", message = "El teléfono debe tener 9 dígitos")
    @Column(name = "telefono", nullable = false)
    private String telefono;
}
