package com.reniec.reniec_api.model;

import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
