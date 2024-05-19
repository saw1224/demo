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

import com.saul.demo.modelos.Consultorio;

import com.saul.demo.servicios.ConsultorioServicios;


@RestController
@RequestMapping("/Consultorio")
public class ConsultorioControlador {
@Autowired
    private ConsultorioServicios consultorioServicios;



@GetMapping
    public List<Consultorio> list() {
        return consultorioServicios.findAll();

    }



    @GetMapping("/{idConsultorio}")
    public ResponseEntity<?> show(@PathVariable("idConsultorio") Integer idConsultorio) {
        Optional<Consultorio> o = consultorioServicios.findById(idConsultorio);
        if (o.isPresent()) {
            return ResponseEntity.ok(o.orElseThrow());

        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Consultorio consultorio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consultorioServicios.save(consultorio));

    }

    @PutMapping("/{idConsultorio}")
    public ResponseEntity<?> update(@RequestBody Consultorio consultorio,
            @PathVariable("idConsultorio") Integer id) {
        Optional<Consultorio> optional = consultorioServicios.update(consultorio, id);
        if (optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(optional.orElseThrow());

        }
        return ResponseEntity.notFound().build();
    }


      @DeleteMapping("/{idConsultorio}")
    public ResponseEntity<?> delete(@PathVariable("idConsultorio") Integer id) {
        Optional<Consultorio> optional = consultorioServicios.findById(id);
        if (optional.isPresent()) {
            consultorioServicios.remove(id);
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.notFound().build();
    }


}


