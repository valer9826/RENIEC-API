package com.reniecweb.web.repository;

import java.util.List;
import java.util.Map;

import com.reniecweb.web.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioConsultaRepository extends JpaRepository<Cliente, String>{
    @Query(value = "select tt.user_id as descripcion, count(tt.persona_dni) as montototal from t_transaccion tt group by tt.user_id", nativeQuery = true)
    List<Map<String, Object>> queryReport();
}
