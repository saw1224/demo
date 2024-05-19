package com.saul.demo.servicios;

import java.util.List;
import java.util.Optional;

import com.saul.demo.modelos.Departamento;


public interface DepartamentoServicios {
List<Departamento> findAll();
Departamento save(Departamento departamento);//INSERT INTO Trabajador VALUES  
Optional<Departamento> findById(Integer id);//SELECT * FROM Trabajador WHERE id = ?
Optional<Departamento> update(Departamento departamento, Integer id);
void remove(Integer id);
}
