package com.saul.demo.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDepartamentos")
    private int id;

    @Column(name = "NombreDepartamento", nullable = false, length = 75)
    private String nombreDepartamento;

    @Column(name = "DescripciónDepartamento", nullable = false, length = 75)
    private String descripcionDepartamento;

    @Column(name = "Imagen", nullable = false, length = 500)
    private String imagen;

    // Constructor por defecto
    public Departamento() {
    }

    // Constructor con parámetros
    public Departamento(String nombreDepartamento, String descripcionDepartamento, String imagen) {
        this.nombreDepartamento = nombreDepartamento;
        this.descripcionDepartamento = descripcionDepartamento;
        this.imagen = imagen;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getDescripcionDepartamento() {
        return descripcionDepartamento;
    }

    public void setDescripcionDepartamento(String descripcionDepartamento) {
        this.descripcionDepartamento = descripcionDepartamento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nombreDepartamento='" + nombreDepartamento + '\'' +
                ", descripcionDepartamento='" + descripcionDepartamento + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
