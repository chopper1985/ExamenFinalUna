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
import org.hibernate.Session;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Josue
 */
public class AuthorContactDAOImpl implements AuthorContactDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    public AuthorContactDAOImpl(AuthorDAO autorDAO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AuthorContactDAOImpl() {
    }



    @Override
    public List<AuthorContact> findAll() {
        List<AuthorContact> listAuthor = new ArrayList<>();

        listAuthor = session.createCriteria(Author.class).list();

        return listAuthor;
    }

    @Override
    public AuthorContact save(AuthorContact authorContact) {
        session.beginTransaction();
        session.save(authorContact);
        session.getTransaction().commit();

        return authorContact;
    }

 

    @Override
    public boolean deleteAll() {

   

        return true;
    }
}
