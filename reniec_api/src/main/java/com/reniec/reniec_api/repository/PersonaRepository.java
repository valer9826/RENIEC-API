package com.reniec.reniec_api.repository;

import java.util.Optional;

import com.reniec.reniec_api.model.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String> {
    @Query(value = "SELECT p FROM Persona p WHERE p.dni=?1")
    Optional<Persona> findByDni(String dni);

}