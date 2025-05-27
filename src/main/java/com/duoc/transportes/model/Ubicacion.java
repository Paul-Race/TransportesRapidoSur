package com.duoc.transportes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ubicacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String latitud;

    @Column(nullable = false)
    private String longitud;

}