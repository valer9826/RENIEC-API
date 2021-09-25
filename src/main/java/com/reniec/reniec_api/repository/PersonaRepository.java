package com.reniec.reniec_api.repository;

import com.reniec.reniec_api.model.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String> {

    @Query(value = "SELECT * FROM Persona p where p.dni=?1 ")
   /* Persona findbyPersona(Persona persona); */
   Optional<Persona> findItemsByPersona(Persona persona);
}
