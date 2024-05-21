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
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, length = 75)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 75)
    private String descripcion;

    @Column(name = "Imagen", columnDefinition ="NVARCHAR(500)",  nullable = false)
    private String imagen;

   @OneToMany(targetEntity = Consultorio.class, fetch = FetchType.LAZY, mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
   @JsonIgnoreProperties(value ="departamento")
   private List<Consultorio> consultorios;


}