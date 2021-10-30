package reniec.cliente.apicliente.controller;

import java.util.Optional;
import java.text.ParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reniec.cliente.apicliente.model.Persona;
import reniec.cliente.apicliente.repository.PersonaRepository;


@RestController
@RequestMapping(value = "api/persona", produces = "application/json")
public class PersonaController {
    // private Map<String, Persona> personas;
    private final PersonaRepository personaData;

    public PersonaController(PersonaRepository personaData) throws ParseException {
        this.personaData = personaData;
    }

    /* --------------METODO PARA MOSTRAR TODOS LOS DNI ------------------- */

    // @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<Map<String, Persona>> all() {
    // return new ResponseEntity<Map<String, Persona>>(personas, HttpStatus.OK);
    // }

    @GetMapping(value = "/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> find(@PathVariable String dni) {
        Optional<Persona> p = personaData.findByDni(dni);
        if (p.isPresent())
            return new ResponseEntity<Persona>(p.get(), HttpStatus.OK);
        else
            return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
    }
}
