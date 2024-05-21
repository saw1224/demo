package com.saul.demo.modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consultorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_consultorio", nullable = false)
    private Integer numeroConsultorio;

    @Column(name = "nombre_doctor", nullable = false, length = 60)
    private String nombreDoctor;

    @ManyToOne(targetEntity = Departamento.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento_id", foreignKey = @ForeignKey(name = "FK_departamento_consultorio_id"), nullable = false)
    @JsonIgnoreProperties(value = "consultorios")
    private Departamento departamento;
    
@OneToMany(targetEntity = Cita.class, fetch = FetchType.LAZY, mappedBy = "consultorio")
private List<Cita> citas;

   
}

