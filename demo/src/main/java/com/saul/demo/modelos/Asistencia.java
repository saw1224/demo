package com.saul.demo.modelos;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hora_inicial", columnDefinition = "DATETIME", nullable = false)
    private LocalDate horarioInicial;

    @Column(name = "hora_final", columnDefinition = "DATETIME", nullable = false)
    private LocalDate horarioFinal;

}
