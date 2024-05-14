package com.saul.demo.modelos;

import java.time.LocalDateTime;

import jakarta.persistence.*;

// Clase que representa la entidad Cita

@Entity
@Table(name = "Cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCita")
    private int idCita;

    @Column(name = "Nombre", nullable = false, length = 25)
    private String nombre;

    @Column(name = "ApellidoMaterno", nullable = false, length = 25)
    private String apellidoMaterno;

    @Column(name = "ApellidoPaterno", nullable = false, length = 25)
    private String apellidoPaterno;

    @Column(name = "FechaYHoraReservacion", nullable = false)
    private LocalDateTime fechaYHoraReservacion;

    @Column(name = "Correo", nullable = false, length = 300)
    private String correo;

    @Column(name = "Telefono", nullable = false, length = 10)
    private String telefono;

    @Column(name = "Sintomas", nullable = false, length = 500)
    private String sintomas;

    @ManyToOne
    @JoinColumn(name = "Consultorio_idConsultorio", nullable = false)
    private Consultorio consultorio;

    // Constructor por defecto
    public Cita() {
    }

    // Constructor con parámetros
    public Cita(String nombre, String apellidoMaterno, String apellidoPaterno, LocalDateTime fechaYHoraReservacion, String correo, String telefono, String sintomas, Consultorio consultorio) {
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.fechaYHoraReservacion = fechaYHoraReservacion;
        this.correo = correo;
        this.telefono = telefono;
        this.sintomas = sintomas;
        this.consultorio = consultorio;
    }

    // Getters y Setters
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public LocalDateTime getFechaYHoraReservacion() {
        return fechaYHoraReservacion;
    }

    public void setFechaYHoraReservacion(LocalDateTime fechaYHoraReservacion) {
        this.fechaYHoraReservacion = fechaYHoraReservacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "idCita=" + idCita +
                ", nombre='" + nombre + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", fechaYHoraReservacion=" + fechaYHoraReservacion +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", sintomas='" + sintomas + '\'' +
                ", consultorio=" + consultorio +
                '}';
    }
}

