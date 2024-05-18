package com.saul.demo.servicios;

import java.util.List;
import java.util.Optional;

import com.saul.demo.modelos.Trabajador;

public interface UsuarioServicios  {
List<Trabajador> findAll();//SELECT * FROM Trabajador
Trabajador save(Trabajador trabajador);//INSERT INTO Trabajador VALUES  
Optional<Trabajador> findById(Integer id);//SELECT * FROM Trabajador WHERE id = ?
Optional<Trabajador> update(Trabajador trabajador, Integer id);
void remove(Integer id);
}
