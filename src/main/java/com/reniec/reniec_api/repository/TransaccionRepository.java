package com.reniec.reniec_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.reniec.reniec_api.model.Transaccion;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {
    @Query(value = "SELECT * FROM Persona p where p.dni=?1 ")
    Optional<Transaccion> findItemsByTransaccion(String dni);
}
