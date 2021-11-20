package com.reniec.reniec_api.controller;

// import java.util.Map;
import java.util.Optional;
import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.HashMap;

// import java.util.UUID;

import com.reniec.reniec_api.model.Persona;
import com.reniec.reniec_api.repository.PersonaRepository;
import com.reniec.reniec_api.repository.TransaccionRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/persona", produces = "application/json")
public class PersonaController {
    // private Map<String, Persona> personas;
    private final PersonaRepository personaData;
    private final TransaccionRepository transacData;

    public PersonaController(PersonaRepository personaData, TransaccionRepository transacData) throws ParseException {
        this.personaData = personaData;
        this.transacData = transacData;

        // personas = new HashMap<String, Persona>();

        // Persona p = new Persona();
        // p.setNombre("Renato");
        // p.setApellido("Gonzales");
        // p.setDni("12345678");
        // p.setSexo("M");
        // String fechaNacimiento = "01/01/2001";
        // Date fN = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);
        // p.setFechaNacimiento(fN);
        // p.setEstadoCivil("S");
        // p.setDepartamento("Lima");
        // p.setProvincia("Lima");
        // p.setDistrito("SJL");
        // p.setDireccion("Av. Siempre Viva 123");
        // String id = UUID.randomUUID().toString();
        // p.setId(id);
        // personas.put(p.getDni(), p);
    }

    /* --------------METODO PARA MOSTRAR TODOS LOS DNI ------------------- */

    // @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<Map<String, Persona>> all() {
    // return new ResponseEntity<Map<String, Persona>>(personas, HttpStatus.OK);
    // }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> create(@RequestBody Persona p) {
        personaData.save(p);
        personaData.flush(); // -> id

        return new ResponseEntity<Integer>(p.getId(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> find(@PathVariable String dni) {
        Optional<Persona> p = personaData.findByDni(dni);
        if (p.isPresent()){
            transacData.transactQuery(dni);
            return new ResponseEntity<Persona>(p.get(), HttpStatus.OK);
        }else
            return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
        }

    @PutMapping(value = "/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> update(@PathVariable String dni, @RequestBody Persona p) {
        Optional<Persona> persona = personaData.findByDni(dni);
        if (persona.isPresent()) {
            persona.get().setNombre(p.getNombre());
            persona.get().setApellido(p.getApellido());
            persona.get().setDni(p.getDni());
            persona.get().setSexo(p.getSexo());
            persona.get().setFechaNacimiento(p.getFechaNacimiento());
            persona.get().setEstadoCivil(p.getEstadoCivil());
            persona.get().setDepartamento(p.getDepartamento());
            persona.get().setProvincia(p.getProvincia());
            persona.get().setDistrito(p.getDistrito());
            persona.get().setDireccion(p.getDireccion());
            personaData.save(persona.get());
            personaData.flush();
            return new ResponseEntity<Persona>(persona.get(), HttpStatus.OK);
        } else
            return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
    }
// if (personas.containsKey(dni)) {
// Persona p = personas.get(dni);
// return new ResponseEntity<Persona>(p, HttpStatus.OK);
// } else {
// return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
// }
// }

// }

}