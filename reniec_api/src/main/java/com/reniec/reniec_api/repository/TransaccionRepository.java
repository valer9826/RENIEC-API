package com.reniec.reniec_api.repository;

import java.util.Optional;

import com.reniec.reniec_api.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, String>{

    @Transactional
    @Query(value = "insert into t_transaccion values((select count(t_transaccion)+1 from t_transaccion), CURRENT_TIMESTAMP, :dni, 'Usmp@12')", nativeQuery = true)
    Optional<Transaccion> transactQuery(@Param("dni")String dni);
}
