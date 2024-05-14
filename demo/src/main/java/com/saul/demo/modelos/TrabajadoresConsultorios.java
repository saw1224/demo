package com.saul.demo.modelos;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "TrabajadoresConsultorios")
public class TrabajadoresConsultorios implements Serializable {

    @EmbeddedId
    private TrabajadoresConsultoriosId id;

    @Column(name = "HorarioInicio", nullable = false)
    private LocalTime horarioInicio;

    @Column(name = "HorarioFinal", nullable = false)
    private LocalTime horarioFinal;

    @ManyToOne
    @MapsId("trabajadorId")
    @JoinColumn(name = "Trabajadores_idTrabajador", nullable = false)
    private Trabajador trabajador;

    @ManyToOne
    @MapsId("consultorioId")
    @JoinColumn(name = "consultorios_idconsultorio", nullable = false)
    private Consultorio consultorio;

    // Constructor por defecto
    public TrabajadoresConsultorios() {
    }

    // Constructor con parámetros
    public TrabajadoresConsultorios(TrabajadoresConsultoriosId id, LocalTime horarioInicio, LocalTime horarioFinal) {
        this.id = id;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
    }

    // Getters y Setters
    public TrabajadoresConsultoriosId getId() {
        return id;
    }

    public void setId(TrabajadoresConsultoriosId id) {
        this.id = id;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(LocalTime horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }
}

