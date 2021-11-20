package com.reniec.reniec_api.repository;

import java.util.Optional;

import com.reniec.reniec_api.model.Persona;
import com.reniec.reniec_api.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, String>{
    @Query(value = "insert into t_transaccion values((select count(t_transaccion)+1 from t_transaccion), CURRENT_TIMESTAMP, persona_dni, 'Usmp@12')", nativeQuery = true)
    Optional<Transaccion> transactQuery(Persona dni);
}
