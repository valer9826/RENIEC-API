package com.reniec.reniec_api.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Transaccion;
    private Persona dni;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fecha_Transaccion;
}
