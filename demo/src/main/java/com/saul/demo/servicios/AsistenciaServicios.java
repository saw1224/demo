package com.saul.demo.servicios;

import java.util.List;
import java.util.Optional;

import com.saul.demo.modelos.Asistencia;


public interface AsistenciaServicios {
List<Asistencia> findAll();
Asistencia save(Asistencia consultorio);//INSERT INTO Trabajador VALUES  
Optional<Asistencia> findById(Integer id);//SELECT * FROM Trabajador WHERE id = ?
Optional<Asistencia> update(Asistencia consultorio, Integer id);
void remove(Integer id);
}
