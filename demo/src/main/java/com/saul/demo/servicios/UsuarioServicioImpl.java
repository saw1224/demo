package com.saul.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saul.demo.modelos.Trabajador;
import com.saul.demo.repositorios.UsuarioRespositorio;
@Service
public class UsuarioServicioImpl implements UsuarioServicios {

    @Autowired
    private UsuarioRespositorio usuarioRepositorio;
    @Override
    public List<Trabajador> findAll() {
       List<Trabajador> trabajador = (List<Trabajador>) usuarioRepositorio.findAll();  
       return trabajador;
    }


    @Override
    public Trabajador save(Trabajador trabajador) {
       return (Trabajador) usuarioRepositorio.save(trabajador);
    }

    @Override
    public Optional<Trabajador> findById(Integer id) {
      return usuarioRepositorio.findById(id);
    }

    @Override
    public Optional<Trabajador> update(Trabajador trabajador, Integer id) {
       Optional<Trabajador> optional = usuarioRepositorio.findById(id);
       Trabajador trabajadorOptional = null;
       if (optional.isPresent()) {
        Trabajador trabajadorDb = optional.orElseThrow();
        trabajadorDb.setNombre(trabajador.getNombre());
        trabajadorDb.setApellidomaterno(trabajador.getApellidomaterno());
        trabajadorDb.setApellidopaterno(trabajador.getApellidopaterno());
        trabajadorDb.setUsuarios(trabajador.getUsuarios());
        trabajadorDb.setPassword(trabajador.getPassword());
        trabajadorDb.setDescripcion(trabajador.getDescripcion());

        trabajadorOptional = usuarioRepositorio.save(trabajadorDb);
       }
       return Optional.ofNullable(trabajadorOptional);
    }


    @Override
    public void remove(Integer id) {

        usuarioRepositorio.deleteById(id);

    }

}
