package com.saul.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.saul.demo.modelos.Asistencia;
import com.saul.demo.servicios.AsistenciaServicios;



@RestController
@RequestMapping("/Asistencia")
public class AsistenciaControlador {


     @Autowired
    private AsistenciaServicios asistenciaServicios;

    @GetMapping
    public List<Asistencia> list() {
        return asistenciaServicios.findAll();

    }

    @GetMapping("/{idAsistencia}")
    public ResponseEntity<?> show(@PathVariable("idAsistencia") Integer idAsistencia) {
        Optional<Asistencia> o = asistenciaServicios.findById(idAsistencia);
        if (o.isPresent()) {
            return ResponseEntity.ok(o.orElseThrow());

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Asistencia asistencia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(asistenciaServicios.save(asistencia));

    }

    @PutMapping("/{idAsistencia}")
    public ResponseEntity<?> update(@RequestBody Asistencia asistencia, @PathVariable("idAsistencia") Integer id) {
        Optional<Asistencia> optional = asistenciaServicios.update(asistencia, id);
        if (optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(optional.orElseThrow());

        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idAsistencia}")
    public ResponseEntity<?> delete(@PathVariable("idAsistencia") Integer id) {
        Optional<Asistencia> optional = asistenciaServicios.findById(id);
        if (optional.isPresent()) {
            asistenciaServicios.remove(id);
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.notFound().build();
    }
}
