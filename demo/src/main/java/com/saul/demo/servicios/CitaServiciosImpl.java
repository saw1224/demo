package com.saul.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saul.demo.modelos.Cita;

import com.saul.demo.repositorios.CitaRepositorio;


@Service
public class CitaServiciosImpl implements CitaServicios {
    @Autowired
    private CitaRepositorio citaRepositorio;

    @Override
    public List<Cita> findAll() {
        List<Cita> cita = (List<Cita>) citaRepositorio.findAll();
        return cita;
    }

    @Override
    public Cita save(Cita cita) {
        return (Cita) citaRepositorio.save(cita);
    }

    @Override
    public Optional<Cita> findById(Integer id) {
        return citaRepositorio.findById(id);
    }

   @Override
    public Optional<Cita> update(Cita cita, Integer id) {
       Optional<Cita> optional = citaRepositorio.findById(id);
       Cita citaOptional = null;
       if (optional.isPresent()) {
        Cita citaDb = optional.orElseThrow();
        citaDb.setNombre(cita.getNombre());
        citaDb.setApellidoMaterno(cita.getApellidoMaterno());
        citaDb.setApellidoPaterno(cita.getApellidoPaterno());
        citaDb.setFechaYHoraReservacion(cita.getFechaYHoraReservacion());
        citaDb.setCorreo(cita.getCorreo());
        citaDb.setTelefono(cita.getTelefono());
        citaDb.setSintomas(cita.getSintomas());
        

        citaOptional = citaRepositorio.save(citaDb);
       }
       return Optional.ofNullable(citaOptional);
    }

    @Override
    public void remove(Integer id) {

        citaRepositorio.deleteById(id);

    }
}
