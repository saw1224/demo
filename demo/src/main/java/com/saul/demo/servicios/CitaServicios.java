package com.saul.demo.servicios;

import java.util.List;
import java.util.Optional;

import com.saul.demo.modelos.Cita;


public interface CitaServicios{
    List<Cita> findAll();

    Cita save(Cita cita, Integer idConsultorio);
    Optional<Cita> update(Cita cita, Integer idCita);
}
