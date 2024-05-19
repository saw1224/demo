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
    public int getIdAsistencia() {
        return idAsistencia;
    }
    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }
    public LocalDateTime getHorarioInicial() {
        return horarioInicial;
    }
    public void setHorarioInicial(LocalDateTime horarioInicial) {
        this.horarioInicial = horarioInicial;
    }
    public LocalDateTime getHorarioFinal() {
        return horarioFinal;
    }
    public void setHorarioFinal(LocalDateTime horarioFinal) {
        this.horarioFinal = horarioFinal;
    }
}





