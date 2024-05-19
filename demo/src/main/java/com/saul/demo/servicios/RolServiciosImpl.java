package com.saul.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saul.demo.modelos.Rol;
import com.saul.demo.repositorios.RolRepositorio;

@Service
public class RolServiciosImpl implements RolServicios {

   @Autowired
   private RolRepositorio rolRepositorio;

   @Override
   public List<Rol> findAll() {
      List<Rol> rol = (List<Rol>) rolRepositorio.findAll();
      return rol;
   }

   @Override
   public Rol save(Rol rol) {
      return (Rol) rolRepositorio.save(rol);
   }

   @Override
   public Optional<Rol> findById(Integer id) {
      return rolRepositorio.findById(id);
   }

   @Override
   public Optional<Rol> update(Rol rol, Integer id) {
      Optional<Rol> optional = rolRepositorio.findById(id);
      Rol rolOptional = null;
      if (optional.isPresent()) {
         Rol rolDb = optional.orElseThrow();
         rolDb.setDescripcion(rol.getDescripcion());
         rolOptional = rolRepositorio.save(rolDb);
      }
      return Optional.ofNullable(rolOptional);
   }

   @Override
   public void remove(Integer id) {

      rolRepositorio.deleteById(id);

   }



}
