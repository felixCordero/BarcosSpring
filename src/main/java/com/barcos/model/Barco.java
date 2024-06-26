package com.barcos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Barco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_barco")
    private String nombre;
    @Column(name = "tipo_barco")
    private String tipo;
    @Column(name = "eslora")
    private int eslora;
    @Column(name = "manga")
    private int manga;
    @Column(name = "capacidad")
    private int capacidad;
    @OneToOne(mappedBy = "barco", cascade = CascadeType.ALL)
    private Amarre amarre;
}
