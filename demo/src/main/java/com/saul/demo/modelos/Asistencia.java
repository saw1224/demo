package com.saul.demo.modelos;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
(name = "Asistencia")
public class Asistencia {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "idAsistencia")
    private int idAsistencia;

    @Column(name = "HorarioInicial", nullable = false)
    private LocalDateTime horarioInicial;
    @Column(name = "HorarioFinal", nullable = false)
    private LocalDateTime horarioFinal;
}


