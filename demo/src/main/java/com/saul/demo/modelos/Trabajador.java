package com.saul.demo.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
@Entity
@Table(name = "Trabajador")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTrabajador")
    private int idTrabajador;

    @Column(name = "Nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "ApellidoMaterno", nullable = false, length = 45)
    private String apellidoMaterno;

    @Column(name = "ApellidoPaterno", nullable = false, length = 45)
    private String apellidoPaterno;

    @Column(name = "Usuarios", nullable = false, length = 45)
    private String usuarios;

    @Column(name = "Password", nullable = false, length = 45)
    private String password;

    @Column(name = "Descripcion", length = 600)
    private String descripcion;

    // Constructor por defecto
    public Trabajador() {
    }

    // Constructor con parámetros
    public Trabajador(String nombre, String apellidoMaterno, String apellidoPaterno, String usuarios, String password, String descripcion) {
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.usuarios = usuarios;
        this.password = password;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
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

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "idTrabajador=" + idTrabajador +
                ", nombre='" + nombre + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", usuarios='" + usuarios + '\'' +
                ", password='" + password + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}


