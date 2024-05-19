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

import com.saul.demo.modelos.Rol;

import com.saul.demo.servicios.RolServicios;

@RestController
@RequestMapping("/Roles")
public class RolControlador {
    @Autowired
    private RolServicios rolServicios;

    @GetMapping
    public List<Rol> list() {
        return rolServicios.findAll();

    }

    @GetMapping("/{idRol}")
    public ResponseEntity<?> show(@PathVariable("idRol") Integer idRol) {
        Optional<Rol> o = rolServicios.findById(idRol);
        if (o.isPresent()) {
            return ResponseEntity.ok(o.orElseThrow());

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Rol rol) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rolServicios.save(rol));

    }

    @PutMapping("/{idRol}")
    public ResponseEntity<?> update(@RequestBody Rol rol, @PathVariable("idTrabajador") Integer id) {
        Optional<Rol> optional = rolServicios.update(rol, id);
        if (optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(optional.orElseThrow());

        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idRol}")
    public ResponseEntity<?> delete(@PathVariable("idRol") Integer id) {
        Optional<Rol> optional = rolServicios.findById(id);
        if (optional.isPresent()) {
            rolServicios.remove(id);
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.notFound().build();
    }

}
