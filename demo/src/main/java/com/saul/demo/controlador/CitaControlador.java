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
    public ResponseEntity<?> get(@PathVariable("idCita") Integer idCita) {
        Optional<Cita> cita = citaServicios.findById(idCita);
        if (cita.isPresent()) {
            return ResponseEntity.ok().body(cita.orElseThrow());
        }
return ResponseEntity.notFound().build();

    }

    

    @PostMapping("/{idConsultorio}/Cita")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Cita cita,

            @PathVariable(value = "idConsultorio") Integer idConsultoio) {

        return ResponseEntity.status(HttpStatus.CREATED).body(citaServicios.save(cita, idConsultoio));

    }

    @PutMapping("/{idCita}")

    public ResponseEntity<?> update(@RequestBody Cita cita, @PathVariable(value = "idCita") Integer idCita) {

        Optional<Cita> citaOptional = citaServicios.update(cita, idCita);

        if (citaOptional.isPresent()) {

            return ResponseEntity.status(HttpStatus.CREATED).body(citaOptional.orElseThrow());

        }

        return ResponseEntity.notFound().build();
    }



    @DeleteMapping("/{idCita}")

    public ResponseEntity<?> remove(@PathVariable(value = "idCita") Integer idCita) {

        Optional<Cita> citaOptional = citaServicios.findById(idCita);

        if (citaOptional.isPresent()) {

            citaServicios.remove(idCita);

            return ResponseEntity.noContent().build();

        }

        return ResponseEntity.notFound().build();
    }

}
