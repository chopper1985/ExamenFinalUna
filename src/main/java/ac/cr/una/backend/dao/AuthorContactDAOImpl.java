/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.AuthorContact;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Josue
 */
public class AuthorContactDAOImpl implements AuthorContactDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<AuthorContact> findAll() {
        List<AuthorContact> listAuthor = new ArrayList<>();

        listAuthor = session.createCriteria(AuthorContact.class).list();

        return listAuthor;
    }

    @Override
    public AuthorContact save(AuthorContact authorContact) {

        List<Author> listaAuthor = new ArrayList<>();
        
        int idAuthor;
        
        //Busqueda por nombre

        String hql = "from author where idAuthor = :idAuthor";
        Query query = session.createQuery(hql);
        query.setParameter("idAuthor", authorContact.getAuthor().getIdAuthor());

        if (query.list().size() > 0) {
            session.beginTransaction();
            
            authorContact.setAuthor((Author) query.list().get(0));
            session.save(authorContact);
            session.getTransaction().commit();
        } else {
            session.beginTransaction();         
            idAuthor = (int) session.save(authorContact.getAuthor());
            authorContact.getAuthor().setIdAuthor(idAuthor);
            session.save(authorContact);
            session.getTransaction().commit();
        }

        return authorContact;
    }

    @Override
    public boolean deleteAll() {
        boolean returnRes = false;
        List<AuthorContact> listAuthor;

        listAuthor = findAll();
        try {

            listAuthor.stream().map((authorContact) -> {
                session.beginTransaction();
                return authorContact;
            }).map((authorContact) -> {
                session.delete(authorContact);
                return authorContact;
            }).forEachOrdered((_item) -> {
                session.getTransaction().commit();
            });

            returnRes = true;

        } catch (ConstraintViolationException ex) {
            returnRes = false;

        } catch (Exception e) {
            returnRes = false;
        }

        return returnRes;

    }
}
