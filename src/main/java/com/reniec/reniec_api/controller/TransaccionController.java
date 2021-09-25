package com.reniec.reniec_api.controller;

import com.reniec.reniec_api.model.Transaccion;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
/*Transaccion */
@RestController
@RequestMapping(value = "api/transaccion", produces = "application/json")
public class TransaccionController {

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody Transaccion t) {

        return new ResponseEntity<String>(HttpStatus.CREATED);
    }
    // Deploy
}
