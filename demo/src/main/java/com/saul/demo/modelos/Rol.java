package com.saul.demo.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private int idRol;

    @Column(name = "Descripcion", nullable = false, length = 20)
    private String descripcion;

    // Constructor por defecto
    public Rol() {
    }

    // Constructor con parámetros
    public Rol(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "idRol=" + idRol +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

