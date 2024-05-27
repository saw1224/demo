package com.saul.demo.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saul.demo.modelos.Cita;
import com.saul.demo.modelos.Consultorio;
import com.saul.demo.repositorios.CitaRepositorio;
import com.saul.demo.repositorios.ConsultorioRepositorio;

import org.springframework.transaction.annotation.Transactional;


@Service
public class CitaServiciosImpl implements CitaServicios {
    @Autowired
    private CitaRepositorio citaRepositorio;
    @Autowired
    private ConsultorioRepositorio consultorioRepositorio;

    @Override
    public List<Cita> findAll() {
        return (List<Cita>) citaRepositorio.findAll();
    }

    @Override
    public Cita save(Cita cita, Integer idConsultorio) {
        Cita citaMapeada = mapeaCita(cita);
        Consultorio consultorio = consultorioRepositorio.findById(idConsultorio).orElseThrow();
        citaMapeada.setConsultorio(consultorio);
        Cita citaGuardada = citaRepositorio.save(citaMapeada);
        return (Cita) citaRepositorio.save(citaGuardada);
    }

    private Cita mapeaCita(Cita cita) {

        Cita citaMapeada = new Cita();

        citaMapeada.setNombre(cita.getNombre());

        citaMapeada.setApellidoPaterno(cita.getApellidoPaterno());

        citaMapeada.setApellidoMaterno(cita.getApellidoMaterno());

        citaMapeada.setFechaReservacion(cita.getFechaReservacion());

        citaMapeada.setTelefono(cita.getTelefono());

        citaMapeada.setCorreo(cita.getCorreo());

        citaMapeada.setSintomas(cita.getSintomas());

        return citaMapeada;

    }

    @Override

    public Optional<Cita> update(Cita cita, Integer idCita) {

        Optional<Cita> citaOptional = citaRepositorio.findById(idCita);

        Cita citaActualizada = null;

        if (citaOptional.isPresent()) {

            Cita citaGuardada = citaOptional.orElseThrow();

            citaGuardada.setNombre(cita.getNombre());

            citaGuardada.setApellidoPaterno(cita.getApellidoPaterno());
            citaGuardada.setApellidoMaterno(cita.getApellidoMaterno());
            citaGuardada.setFechaReservacion(cita.getFechaReservacion());
            citaGuardada.setTelefono(cita.getTelefono());
            citaGuardada.setSintomas(cita.getSintomas());

            citaActualizada = citaRepositorio.save(citaGuardada);

        }

        return Optional.ofNullable(citaActualizada);
    }

    @Override
    @Transactional
    public void remove(Integer idCita) {
        citaRepositorio.deleteById(idCita);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cita> findById(Integer idCita) {
        return citaRepositorio.findById(idCita);
    }

}
