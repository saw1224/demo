package com.saul.demo.servicios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saul.demo.modelos.Consultorio;
import com.saul.demo.repositorios.ConsultorioRepositorio;


@Service
public class ConsultorioServiciosImpl implements ConsultorioServicios{
   
    @Autowired
    private ConsultorioRepositorio consultorioRepositorio;

    @Override
    public List<Consultorio> findAll() {
        List<Consultorio> consultorio = (List<Consultorio>) consultorioRepositorio.findAll();
        return consultorio;
    }

    @Override
    public Consultorio save(Consultorio consultorio) {
        return (Consultorio) consultorioRepositorio.save(consultorio);
    }

    @Override
    public Optional<Consultorio> findById(Integer id) {
        return consultorioRepositorio.findById(id);
    }
    @Override
    public Optional<Consultorio> update(Consultorio consultorio, Integer id) {
        Optional<Consultorio> optional = consultorioRepositorio.findById(id);
        Consultorio consultorioOptional = null;
        if (optional.isPresent()) {
            Consultorio consultorioDb = optional.orElseThrow();
            consultorioDb.setNumeroConsultorio(consultorio.getNumeroConsultorio());
            consultorioDb.setNombreDelDoctor(consultorio.getNombreDelDoctor());
            consultorioOptional = consultorioRepositorio.save(consultorioDb);
        }
        return Optional.ofNullable(consultorioOptional);
    }

    @Override
    public void remove(Integer id) {

        consultorioRepositorio.deleteById(id);

    }

}

