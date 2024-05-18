package com.saul.demo.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Trabajador")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTrabajador")
    private Integer idTrabajador;

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
@ManyToMany
@JoinTable(name = "Trabajador_rol", joinColumns = @JoinColumn(name = "Trabajador_id"), inverseJoinColumns = @JoinColumn(name = "Rol_id"),uniqueConstraints = {@UniqueConstraint(columnNames = {"FK_Trabajador_id","FK_Rol_id"})}  )
private List<Rol> roles;

@ManyToMany
@JoinTable(name = "Trabajador_consultorio", joinColumns =  @JoinColumn(name = "Trabajador_id"), inverseJoinColumns = @JoinColumn(name = "Consultorio_id"),uniqueConstraints = {@UniqueConstraint(columnNames = {"FK_Trabajador_id","FK_Consultorio_id"})}  )
private List<Consultorio> consultorios;

@ManyToMany
@JoinTable(name = "Trabajador_Asistencia", joinColumns =  @JoinColumn(name = "Trabajador_id"), inverseJoinColumns = @JoinColumn(name = "Asistencia_id"),uniqueConstraints = {@UniqueConstraint(columnNames = {"FK_Trabajador_id","FK_Asistencia_id"})}  )
private List<Asistencia> asistencias;

    // Constructor por defecto
    public Trabajador() {
    }

    public Trabajador(Integer idTrabajador, String nombre, String apellidoMaterno, String apellidoPaterno,
            String usuarios, String password, String descripcion, List<Rol> roles, List<Consultorio> consultorios,
            List<Asistencia> asistencias) {
        this.idTrabajador = idTrabajador;
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.usuarios = usuarios;
        this.password = password;
        this.descripcion = descripcion;
        this.roles = roles;
        this.consultorios = consultorios;
        this.asistencias = asistencias;
    }

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
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

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public List<Consultorio> getConsultorios() {
        return consultorios;
    }

    public void setConsultorios(List<Consultorio> consultorios) {
        this.consultorios = consultorios;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    @Override
    public String toString() {
        return "Trabajador [idTrabajador=" + idTrabajador + ", nombre=" + nombre + ", apellidoMaterno="
                + apellidoMaterno + ", apellidoPaterno=" + apellidoPaterno + ", usuarios=" + usuarios + ", password="
                + password + ", descripcion=" + descripcion + ", roles=" + roles + ", consultorios=" + consultorios
                + ", asistencias=" + asistencias + "]";
    }

    

   
}


