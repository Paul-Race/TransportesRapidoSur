package com.duoc.transportes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="envios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer pagoId;

    @Column(nullable = false)
    private Integer receptorId;

    @Column(nullable = false)
    private Integer remitenteId;

    @Column(nullable = true)
    private Integer rutaId;

    @Column(nullable = false)
    private Integer ubicacionId;

    @Column(nullable = false)
    private boolean isActive;

}
