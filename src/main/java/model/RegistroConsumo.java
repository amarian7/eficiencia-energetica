package com.fiap.eficiencia.energetica.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "REGISTRO_CONSUMO")
@Data
public class RegistroConsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String local;
    private String equipamento;

    @Column(name = "consumo_kwh")
    private BigDecimal consumoKwh;

    @Column(name = "limite_alerta")
    private BigDecimal limiteAlerta;

    @Column(name = "data_registro")
    private LocalDateTime dataRegistro = LocalDateTime.now();
}