package com.saul.demo.modelos;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TrabajadoresConsultoriosId implements Serializable {

    private int trabajadorId;
    private int consultorioId;

    // Constructor por defecto
    public TrabajadoresConsultoriosId() {
    }

    // Constructor con parámetros
    public TrabajadoresConsultoriosId(int trabajadorId, int consultorioId) {
        this.trabajadorId = trabajadorId;
        this.consultorioId = consultorioId;
    }

    // Getters y Setters
    public int getTrabajadorId() {
        return trabajadorId;
    }

    public void setTrabajadorId(int trabajadorId) {
        this.trabajadorId = trabajadorId;
    }

    public int getConsultorioId() {
        return consultorioId;
    }

    public void setConsultorioId(int consultorioId) {
        this.consultorioId = consultorioId;
    }

    // HashCode y Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrabajadoresConsultoriosId that = (TrabajadoresConsultoriosId) o;
        return trabajadorId == that.trabajadorId && consultorioId == that.consultorioId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trabajadorId, consultorioId);
    }
}

