package com.barcos.dao;

import com.barcos.model.Barco;
import com.barcos.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class BarcoDaoImpl implements BarcoDao {
    private SessionFactory sessionFactory;
    private Transaction transaction = null;
    private Session session = null;

    public BarcoDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createBarco(Barco barco) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(barco);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al crear el barco: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Barco obtenerBarcoById(int id) {
        Barco barco = null;
        try {
            session = sessionFactory.openSession();
            barco = session.get(Barco.class, id);
        } catch (HibernateException e) {
            System.out.println("Error al obtener el barco: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
        return barco;
    }

    @Override
    public List<Barco> obtenerBarcosTodos() {
        List<Barco> barcos = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            barcos = session.createQuery("from Barco", Barco.class).list();
            session.close();
            return barcos;
        } catch (HibernateException e) {
            System.out.println("Error al obtener la lista de barcos: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
        return barcos;
    }

    @Override
    public void actualizarBarco(Barco barco) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(barco);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Error al actualizar el barco: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void eliminarBarco(Barco barco) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(barco);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Error al eliminar el barco: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }
}
