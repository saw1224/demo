package com.saul.demo.servicios;

import java.util.List;
import java.util.Optional;

import com.saul.demo.modelos.Rol;


public interface RolServicios {
List<Rol> findAll();
Rol save(Rol rol);//INSERT INTO Trabajador VALUES  
Optional<Rol> findById(Integer id);//SELECT * FROM Trabajador WHERE id = ?
Optional<Rol> update(Rol rol, Integer id);
void remove(Integer id);

}
