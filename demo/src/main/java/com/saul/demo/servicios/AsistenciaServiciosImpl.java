package com.saul.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saul.demo.modelos.Asistencia;

import com.saul.demo.repositorios.AsistenciaRepositorio;

@Service
public class AsistenciaServiciosImpl implements AsistenciaServicios{
   @Autowired
    private AsistenciaRepositorio asistenciaRepositorio;

    @Override
    public List<Asistencia> findAll() {
        List<Asistencia> asistencia = (List<Asistencia>) asistenciaRepositorio.findAll();
        return asistencia;
    }

    @Override
    public Asistencia save(Asistencia asistencia) {
        return (Asistencia) asistenciaRepositorio.save(asistencia);
    }

    @Override
    public Optional<Asistencia> findById(Integer id) {
        return asistenciaRepositorio.findById(id);
    }

   @Override
    public Optional<Asistencia> update(Asistencia asistencia, Integer id) {
       Optional<Asistencia> optional = asistenciaRepositorio.findById(id);
       Asistencia asistenciaOptional = null;
       if (optional.isPresent()) {
        Asistencia asistenciaDb = optional.orElseThrow();
        asistenciaDb.setHorarioInicial(asistencia.getHorarioInicial());
        asistenciaDb.setHorarioFinal(asistencia.getHorarioFinal());
     
    
        asistenciaOptional = asistenciaRepositorio.save(asistenciaDb);
       }
       return Optional.ofNullable(asistenciaOptional);
    }

    @Override
    public void remove(Integer id) {

        asistenciaRepositorio.deleteById(id);

    }
}
