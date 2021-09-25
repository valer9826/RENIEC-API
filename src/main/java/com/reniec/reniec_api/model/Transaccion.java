package com.reniec.reniec_api.model;
import com.reniec.reniec_api.model.Persona;
import java.util.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Transaccion {
    private int id_Transaccion;
    private String usuario;
    private Persona dni;
    private Date fecha_Transaccion;
}
