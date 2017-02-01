/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.BookType;
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
public class BookTypeDAOHibernateImpl implements BookTypeDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public BookType save(BookType bookType) {
        session.beginTransaction();
        session.save(bookType);
        session.getTransaction().commit();

        return bookType;
    }

    @Override
    public boolean deleteAll() {
        boolean returnRes = false;
        List<BookType> listBook;

        listBook = findAll();

        try {
            listBook.stream().map((book) -> {
                session.beginTransaction();
                return book;
            }).map((book) -> {
                session.delete(book);
                return book;
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

    public List<BookType> findAll() {
        List<BookType> listbook = new ArrayList<>();

        listbook = session.createCriteria(BookType.class).list();

        return listbook;
    }

    @Override
    public BookType findByName(String name) {
      
        //Busqueda por nombre
        Query query = session.createQuery("from booktype where type = :type");
        query.setParameter("type", name);

        BookType bookType = null;

        if (query.list().size() > 0) {
            bookType = (BookType) query.list().get(0);
        }

        return bookType;
    }
}
