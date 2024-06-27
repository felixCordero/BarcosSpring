package com.barcos;

import com.barcos.model.Amarre;
import com.barcos.model.Barco;
import com.barcos.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Barco barco = new Barco();
        barco.setNombre("Barco Ejemplo");
        barco.setTipo("Velero");
        barco.setEslora(10);
        barco.setManga(3);
        barco.setCapacidad(6);

        Amarre amarre = new Amarre();
        amarre.setUbicacion("A-1");
        amarre.setPrecio(1500.0);
        amarre.setProfundidad(5);
        amarre.setLongitud(12);
        amarre.setElectricidad(true);

        barco.setAmarre(amarre);
        amarre.setBarco(barco);

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(barco);
            session.persist(amarre);
            transaction.commit();
        }
    }
}