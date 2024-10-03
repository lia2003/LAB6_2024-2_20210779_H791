package com.example.lab6_20242_20210779_h791.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "eventos")
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventoId", nullable = false)
    private Integer eventoId;

    @NotBlank(message = "El nombre del evento es obligatorio.")
    @Size(min = 3, max = 100, message = "El nombre del evento debe tener entre 3 y 100 caracteres.")
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @NotNull(message = "La fecha del evento es obligatoria.")
    @Future(message = "La fecha del evento debe ser una fecha futura.")
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @NotNull(message = "El número de asistentes esperados es obligatorio.")
    @Positive(message = "El número de asistentes esperados debe ser un número positivo.")
    @Column(name = "asistentesEsperados", nullable = false)
    private Integer asistentesEsperados;

}
