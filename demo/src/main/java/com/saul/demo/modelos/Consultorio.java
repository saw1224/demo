package com.saul.demo.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Consultorio")
public class Consultorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConsultorio")
    private Integer idConsultorio;

    @Column(name = "NumeroConsultorio", nullable = false)
    private Integer numeroConsultorio;

    @Column(name = "NombreDelDoctor", nullable = false, length = 60)
    private String nombreDelDoctor;

    @ManyToOne
    @JoinColumn(name = "departamentos_idDepartamentos", nullable = false)
    private Departamento departamento;

    // Constructor por defecto
    public Consultorio() {
    }

    // Constructor con parámetros
    public Consultorio(Integer numeroConsultorio, String nombreDelDoctor, Departamento departamento) {
        this.numeroConsultorio = numeroConsultorio;
        this.nombreDelDoctor = nombreDelDoctor;
        this.departamento = departamento;
    }

    // Getters y Setters
    public Integer getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(Integer idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public Integer getNumeroConsultorio() {
        return numeroConsultorio;
    }

    public void setNumeroConsultorio(Integer numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }

    public String getNombreDelDoctor() {
        return nombreDelDoctor;
    }

    public void setNombreDelDoctor(String nombreDelDoctor) {
        this.nombreDelDoctor = nombreDelDoctor;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Consultorio{" +
                "idConsultorio=" + idConsultorio +
                ", numeroConsultorio=" + numeroConsultorio +
                ", nombreDelDoctor='" + nombreDelDoctor + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}
