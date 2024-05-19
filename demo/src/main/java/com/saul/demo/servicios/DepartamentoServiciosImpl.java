package com.saul.demo.servicios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saul.demo.modelos.Departamento;
import com.saul.demo.repositorios.DepartamentoRepositorio;

@Service
public class DepartamentoServiciosImpl implements DepartamentoServicios {

    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;

    @Override
    public List<Departamento> findAll() {
        List<Departamento> departamento = (List<Departamento>) departamentoRepositorio.findAll();
        return departamento;
    }

    @Override
    public Departamento save(Departamento departamento) {
        return (Departamento) departamentoRepositorio.save(departamento);
    }

    @Override
    public Optional<Departamento> findById(Integer id) {
        return departamentoRepositorio.findById(id);
    }

    @Override
    public Optional<Departamento> update(Departamento departamento, Integer id) {
        Optional<Departamento> optional = departamentoRepositorio.findById(id);
        Departamento departamentoOptional = null;
        if (optional.isPresent()) {
            Departamento departamentoDb = optional.orElseThrow();
            departamentoDb.setNombreDepartamento(departamento.getNombreDepartamento());
            departamentoDb.setDescripcionDepartamento(departamento.getDescripcionDepartamento());
            departamentoDb.setImagen(departamento.getImagen());
            departamentoOptional = departamentoRepositorio.save(departamentoDb);
        }
        return Optional.ofNullable(departamentoOptional);
    }

    @Override
    public void remove(Integer id) {

        departamentoRepositorio.deleteById(id);

    }

}
