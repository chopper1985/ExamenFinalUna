/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Author;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Josue
 */
public class AuthorDAOImpl implements AuthorDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public Author findByName(String name) {
        Author autor = null;
        //Busqueda por nombre

        Query query = session.createQuery("from author where name = :name");
        query.setParameter("name", name);

        if (query.list().size() > 0) {
            autor = (Author) query.list().get(0);
        }

        return autor;
    }

    @Override
    public List<Author> findAll() {
        List<Author> listAuthor = new ArrayList<>();

        listAuthor = session.createCriteria(Author.class).list();

        return listAuthor;
    }

}
