package com.saul.demo.controlador;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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



    @PostMapping("/{idDepartamento}/consultorio")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Consultorio consultorio,
    @PathVariable (value = "idDepartamento") Long idDepartamento) {
       
        
            return ResponseEntity.status(HttpStatus.CREATED).body(consultorioServicios.save(consultorio, idDepartamento));

        }
        
    }







