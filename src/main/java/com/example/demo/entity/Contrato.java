package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String identificador;

    private Double valor;

    @Column(name = "nombre_contratante", nullable = false)
    private String nombreContratante;

    @Column(name = "documento_contratante", nullable = false)
    private String documentoContratante;

    @Column(name = "nombre_contratantista", nullable = false)
    private String nombreContratantista;

    @Column(name = "documento_contratantista", nullable = false)
    private String documentoContratantista;

    @Column(name = "fecha_inicial", nullable = false)
    private LocalDate fechaInicial;

    @Column(name = "fecha_final", nullable = false)
    private LocalDate fechaFinal;
}
