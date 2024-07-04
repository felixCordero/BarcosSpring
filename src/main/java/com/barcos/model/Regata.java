package com.barcos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Regata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre_regata")
    private String nombre;
    @Column(name = "lugar_regata")
    private String lugar;
    @Column(name ="fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "distancia")
    private  int distancia;
    @ManyToMany(mappedBy = "regatas")
    private List<Barco> barcos = new ArrayList<Barco>();
}
