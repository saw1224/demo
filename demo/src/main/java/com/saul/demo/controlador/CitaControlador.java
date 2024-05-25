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
import com.saul.demo.modelos.Cita;
import com.saul.demo.servicios.CitaServicios;

@RestController
@RequestMapping("/Cita")
@CrossOrigin("*")
public class CitaControlador {

    @Autowired
    private CitaServicios citaServicios;

    @GetMapping
    public List<Cita> list() {
        return citaServicios.findAll();

    }

    @GetMapping("/{idCita}")
    public ResponseEntity<?> show(@PathVariable("idCita") Integer idCita) {
        Optional<Cita> o = citaServicios.findById(idCita);
        if (o.isPresent()) {
            return ResponseEntity.ok(o.orElseThrow());

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{idConsultoio}/Cita")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Cita cita, 
    @PathVariable("idConsultorio") Integer idConsultoio) {

        return ResponseEntity.status(HttpStatus.CREATED).body(citaServicios.save(cita));

    }

    @PutMapping("/{idCita}")
    public ResponseEntity<?> update(@RequestBody Cita cita, @PathVariable("idCita") Integer id) {
        Optional<Cita> optional = citaServicios.update(cita, id);
        if (optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(optional.orElseThrow());

        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idCita}")
    public ResponseEntity<?> delete(@PathVariable("idCita") Integer id) {
        Optional<Cita> optional = citaServicios.findById(id);
        if (optional.isPresent()) {
            citaServicios.remove(id);
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.notFound().build();
    }

}
