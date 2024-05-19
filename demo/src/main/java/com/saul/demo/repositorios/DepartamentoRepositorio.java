package com.saul.demo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.saul.demo.modelos.Departamento;

public interface DepartamentoRepositorio extends CrudRepository<Departamento, Integer>{

}
