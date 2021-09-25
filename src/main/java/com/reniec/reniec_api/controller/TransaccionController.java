package com.reniec.reniec_api.controller;

import com.reniec.reniec_api.model.Transaccion;
import com.reniec.reniec_api.repository.TransaccionRepository;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/transaccion", produces = "application/json")
public class TransaccionController {

    private final TransaccionRepository transaccionRepository;

    public TransaccionController(TransaccionRepository transaccionData) {
        this.transaccionRepository = transaccionData;
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody Transaccion t) {
        transaccionRepository.save(t);
        transaccionRepository.flush();
        return new ResponseEntity<String>(t.getIdTransaccion(), HttpStatus.CREATED);

    }

}
