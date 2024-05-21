package com.saul.demo.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saul.demo.modelos.Consultorio;
import com.saul.demo.modelos.Departamento;
import com.saul.demo.repositorios.ConsultorioRepositorio;
import com.saul.demo.repositorios.DepartamentoRepositorio;

import jakarta.transaction.Transactional;

@Service
public class ConsultorioServiciosImpl implements ConsultorioServicios {

    @Autowired
    private ConsultorioRepositorio consultorioRepositorio;

    @Override
    @Transactional (readOnly = true)
    public List<Consultorio> findAll() {
        List<Consultorio> consultorios = (List<Consultorio>) consultorioRepositorio.findAll();
        return consultorios;
    }

    @Override
    @Transactional
    public Consultorio save(Consultorio consultorio, Long idDepartamento) {
        Consultorio consultorioMapeado = mapeaConsultorio(consultorio);
        Departamento departamento = departamentoRepositorio.findById(idDepartamento).orElseThrow();
        consultorioMapeado.setDepartamento(departamento);
        Consultorio consultorioGuardado = consultorioRepositorio.save(consultorioMapeado);
        return consultorioRepositorio.save(consultorioGuardado);
    }

    private Consultorio mapeaConsultorio(Consultorio consultorio) {
        Consultorio consultorioMapeado = new Consultorio();
        consultorioMapeado.setNumeroConsultorio(consultorio.getNumeroConsultorio());
        consultorioMapeado.setNombreDoctor(consultorio.getNombreDoctor());
        return consultorioMapeado;

    }

}
