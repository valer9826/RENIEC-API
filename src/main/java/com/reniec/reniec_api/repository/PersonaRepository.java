package com.reniec.reniec_api.repository;
import com.reniec.reniec_api.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonaRepository extends JpaRepository <Persona, String>{
    @Query(value = "SELECT * FROM Persona where ")
    Persona findbyPersona(Persona persona);
}
