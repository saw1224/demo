package com.saul.demo.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import jakarta.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trabajador", uniqueConstraints = {
    @UniqueConstraint(name = "uk_usuario", columnNames = {"usuarios"})
})
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido_paterno", nullable = false, length = 50)
    private String apellidopaterno;

    @Column(name = "apellido_materia", nullable = false, length = 50)
    private String apellidomaterno;

    @Column(name = "usuarios", unique = true, nullable = false, length = 50)
    private String usuarios;

    @Column(name = "password", nullable = false, length = 12)
    private String password;

    @Column(name = "descripcion",nullable = false, length = 600)
    private String descripcion;

@ManyToMany(targetEntity = Asistencia.class, fetch = FetchType.LAZY)
@JoinTable(name = "trabajador_asistencia", joinColumns = @JoinColumn(name = "trabajador", foreignKey = @ForeignKey(name = "FK_trabajador_id")), inverseJoinColumns = @JoinColumn(name = "asistencia", foreignKey = @ForeignKey(name = "FK_asistencia_id")), uniqueConstraints = {@UniqueConstraint(name = "uk_trabajador_asistencia", columnNames = {"trabajador", "asistencia"})  }, indexes = {
    @Index(name = "idx_trabajador_asistencia", columnList = "trabajador,asistencia")
})
private List<Asistencia> asistencia;

@ManyToMany(targetEntity = Asistencia.class, fetch = FetchType.LAZY)
@JoinTable(name = "trabajador_rol", joinColumns = @JoinColumn(name = "trabajador", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_trabajador_rol_id")), inverseJoinColumns = @JoinColumn(name = "rol",referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_rol_id")), uniqueConstraints = {@UniqueConstraint(columnNames = {"trabajador", "rol"},name = "uk_trabajador_rol") }, indexes = {

    @Index(columnList = "trabajador, rol", name = "idx_trabajador_rol")
})
private List<Rol> rols;

@ManyToMany(targetEntity = Consultorio.class, fetch = FetchType.LAZY)
@JoinTable(name = "trabajador_consultorios", joinColumns = @JoinColumn(name = "trabajador", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_trabajador_consultorio_id")), inverseJoinColumns = @JoinColumn(name = "consultorio",referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_consultorio_id")), uniqueConstraints = {@UniqueConstraint(columnNames = {"trabajador", "consultorio"},name = "uk_trabajador_consultorio") }, indexes = {

    @Index(columnList = "trabajador, consultorio", name = "idx_trabajador_consultorio")
})
private List<Consultorio> consultorios;


    

   
}


