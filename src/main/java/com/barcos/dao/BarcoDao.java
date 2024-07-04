package com.barcos.dao;

import com.barcos.model.Barco;

import java.util.List;

public interface BarcoDao {

    // Crear un nuevo Barco
    void createBarco(Barco barco);

    // Leer un barco por Id
    Barco obtenerBarcoById(int id);

    // Leer todos los barcos
    List<Barco> obtenerBarcosTodos();

    // Actualizar un barco
    void actualizarBarco(Barco barco);

    // Eliminar un barco
    void eliminarBarco(Barco barco);
}
