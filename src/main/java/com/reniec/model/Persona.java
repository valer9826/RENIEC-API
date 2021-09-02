package com.reniec.model;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Persona {

    private String id;
    private String nombre;
    private String apellido;
    private String dni;
    private String sexo;
    private Date fechaNacimiento;
    private String estadoCivil;
    private String departamento;
    private String provincia;
    private String distrito;
    private String direccion;
}
