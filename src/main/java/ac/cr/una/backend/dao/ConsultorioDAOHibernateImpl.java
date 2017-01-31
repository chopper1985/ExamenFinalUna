/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Consultorio;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Josue
 */
public class ConsultorioDAOHibernateImpl implements ConsultorioDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<Consultorio> findByName(String text) {
        List<Consultorio> listConsultorio = new ArrayList<>();
        //Busqueda por nombre

        String hql = "FROM Consultorio P WHERE P.nombre = :text";
        Query query = session.createQuery(hql);
        query.setParameter("text", text);

        listConsultorio = query.list();

        return listConsultorio;
    }

    @Override
    public List<Consultorio> findAll() {
        List<Consultorio> listConsultorio = new ArrayList<>();

        listConsultorio = session.createCriteria(Consultorio.class).list();

        return listConsultorio;
    }

    @Override
    public Consultorio save(Consultorio consul) {
        session.beginTransaction();
        session.save(consul);
        session.getTransaction().commit();

        return consul;
    }

    @Override
    public Consultorio update(Consultorio consul) {
        session.beginTransaction();
        session.update(consul);
        session.getTransaction().commit();

        return consul;
    }

    @Override
    public boolean delete(int id) {

        boolean isDeleted = false;
        Consultorio consul = null;

        session.beginTransaction();
        consul = (Consultorio) session.get(Consultorio.class, id);
        session.delete(consul);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }
}
