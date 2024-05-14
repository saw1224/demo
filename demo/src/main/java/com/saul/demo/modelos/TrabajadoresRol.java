package com.saul.demo.modelos;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TrabajadoresRol")
public class TrabajadoresRol implements Serializable {

    @EmbeddedId
    private TrabajadoresRolId id;

    @ManyToOne
    @MapsId("trabajadorId")
    @JoinColumn(name = "Trabajadores_idTrabajador", nullable = false)
    private Trabajador trabajador;

    @ManyToOne
    @MapsId("rolId")
    @JoinColumn(name = "Rol_idRol", nullable = false)
    private Rol rol;

    // Constructor por defecto
    public TrabajadoresRol() {
    }

    // Constructor con parámetros
    public TrabajadoresRol(TrabajadoresRolId id) {
        this.id = id;
    }

    // Getters y Setters
    public TrabajadoresRolId getId() {
        return id;
    }

    public void setId(TrabajadoresRolId id) {
        this.id = id;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    // HashCode y Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrabajadoresRol that = (TrabajadoresRol) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

