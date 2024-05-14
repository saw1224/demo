package com.saul.demo.modelos;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TrabajadoresRolId implements Serializable {

    private int trabajadorId;
    private int rolId;

    // Constructor por defecto
    public TrabajadoresRolId() {
    }

    // Constructor con parámetros
    public TrabajadoresRolId(int trabajadorId, int rolId) {
        this.trabajadorId = trabajadorId;
        this.rolId = rolId;
    }

    // Getters y Setters
    public int getTrabajadorId() {
        return trabajadorId;
    }

    public void setTrabajadorId(int trabajadorId) {
        this.trabajadorId = trabajadorId;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    // HashCode y Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrabajadoresRolId that = (TrabajadoresRolId) o;
        return trabajadorId == that.trabajadorId && rolId == that.rolId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trabajadorId, rolId);
    }
}

