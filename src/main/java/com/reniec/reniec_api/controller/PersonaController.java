package com.reniec.reniec_api.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.reniec.reniec_api.model.Persona;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/persona", produces = "application/json")
public class PersonaController {
    private Map<String, Persona> personas;

    public PersonaController() throws ParseException {
        personas = new HashMap<String, Persona>();

        Persona p = new Persona();
        p.setNombre("Renato");
        p.setApellido("Gonzales");
        p.setDni("12345678");
        p.setSexo("M");
        String fechaNacimiento = "01/01/2001";
        Date fN = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);
        p.setFechaNacimiento(fN);
        p.setEstadoCivil("S");
        p.setDepartamento("Lima");
        p.setProvincia("Lima");
        p.setDistrito("SJL");
        p.setDireccion("Av. Siempre Viva 123");
        String id = UUID.randomUUID().toString();
        p.setId(id);
        personas.put(p.getDni(), p);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Persona>> all() {
        return new ResponseEntity<Map<String, Persona>>(personas, HttpStatus.OK);
    }

    @GetMapping(value = "/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> find(@PathVariable String dni) {
        if (personas.containsKey(dni)) {
            Persona p = personas.get(dni);
            return new ResponseEntity<Persona>(p, HttpStatus.OK);
        } else {
            return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
        }

    }
}
