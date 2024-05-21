package com.saul.demo.servicios;
import java.util.List;
import com.saul.demo.modelos.Consultorio;



public interface ConsultorioServicios {

    List<Consultorio> findAll();
    
    Consultorio save(Consultorio consultorio, Integer idDepartamento);
}
