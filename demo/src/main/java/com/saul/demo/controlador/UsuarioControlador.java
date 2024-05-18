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

import com.saul.demo.modelos.Trabajador;
import com.saul.demo.servicios.UsuarioServicios;

@RestController
@RequestMapping("/trabajadores")

public class UsuarioControlador {
    @Autowired
    private UsuarioServicios usuarioServicios;

    @GetMapping
    public List<Trabajador> list() {
        return usuarioServicios.findAll();

    }
    @GetMapping("/{idTrabajador}")
    public ResponseEntity<?> show(@PathVariable("idTrabajador") Integer
    idTrabajador) {
        Optional<Trabajador> o = usuarioServicios.findById(idTrabajador);
        if (o.isPresent()) {
return ResponseEntity.ok(o.orElseThrow());

    }
    return ResponseEntity.notFound().build();
}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Trabajador trabajador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServicios.save(trabajador));

    }

    @PutMapping("/{idTrabajador}")
    public ResponseEntity<?> update(@RequestBody Trabajador trabajador, @PathVariable("idTrabajador") Integer id) {
        Optional<Trabajador> optional = usuarioServicios.update(trabajador, id);
        if (optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(optional.orElseThrow());

        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idTrabajador}")
    public ResponseEntity<?> delete(@PathVariable("idTrabajador") Integer id) {
        Optional<Trabajador> optional = usuarioServicios.findById(id);
        if (optional.isPresent()) {
            usuarioServicios.remove(id);
            return ResponseEntity.noContent().build();
        

}
return ResponseEntity.notFound().build();
}
}
