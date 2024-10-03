package com.example.lab6_20242_20210779_h791.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "asistentesEsperados")
    private Integer asistentesEsperados;


}
