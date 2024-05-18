package com.saul.demo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.saul.demo.modelos.Trabajador;

public interface UsuarioRespositorio extends CrudRepository<Trabajador, Integer> {

    
}

