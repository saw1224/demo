package com.saul.demo.servicios;

import java.util.List;
import java.util.Optional;

import com.saul.demo.modelos.Consultorio;



public interface ConsultorioServicios {
List<Consultorio> findAll();
Consultorio save(Consultorio consultorio);//INSERT INTO Trabajador VALUES  
Optional<Consultorio> findById(Integer id);//SELECT * FROM Trabajador WHERE id = ?
Optional<Consultorio> update(Consultorio consultorio, Integer id);
void remove(Integer id);
}
