package com.saul.demo.servicios;

import java.util.List;
import java.util.Optional;

import com.saul.demo.modelos.Cita;


public interface CitaServicios {
List<Cita> findAll();
Cita save(Cita consultorio);//INSERT INTO Trabajador VALUES  
Optional<Cita> findById(Integer id);//SELECT * FROM Trabajador WHERE id = ?
Optional<Cita> update(Cita consultorio, Integer id);
void remove(Integer id);
}
