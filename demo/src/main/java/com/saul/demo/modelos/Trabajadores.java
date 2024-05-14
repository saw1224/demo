package com.saul.demo.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trabajadores {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(nullable = false)
private String nombre;

private String apellido;

private String email;

private String password;



public Trabajadores() {
}

public Trabajadores(Long id, String nombre, String apellido, String email, String password) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.password = password;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getApellido() {
    return apellido;
}

public void setApellido(String apellido) {
    this.apellido = apellido;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

@Override
public String toString() {
    return "Trabajadores [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
            + ", password=" + password + "]";
}


}

