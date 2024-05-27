package com.saul.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.saul.demo.modelos.Departamento;

import com.saul.demo.servicios.DepartamentoServicios;

@RestController
@RequestMapping("/Departamento")
@CrossOrigin("*")
public class DepartamentoControlador {
    @Autowired
    private DepartamentoServicios departamentoServicios;

    @GetMapping
    public List<Departamento> list() {
        return departamentoServicios.findAll();

    }

    @GetMapping("/{idDepartamentos}")
    public ResponseEntity<?> show(@PathVariable("idDepartamentos") Integer idDepartamentos) {
        Optional<Departamento> o = departamentoServicios.findById(idDepartamentos);
        if (o.isPresent()) {
            return ResponseEntity.ok(o.orElseThrow());

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Departamento departamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentoServicios.save(departamento));

    }

    @PutMapping("/{idDepartamentos}")
    public ResponseEntity<?> update(@RequestBody Departamento departamento,
            @PathVariable("idDepartamentos") Integer id) {
        Optional<Departamento> optional = departamentoServicios.update(departamento, id);
        if (optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(optional.orElseThrow());

        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idDepartamentos}")
    public ResponseEntity<?> delete(@PathVariable("idDepartamentos") Integer id) {
        Optional<Departamento> optional = departamentoServicios.findById(id);
        if (optional.isPresent()) {
            departamentoServicios.remove(id);
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.notFound().build();
    }

}
