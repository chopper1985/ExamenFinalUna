/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Book;
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
public class BookDAOHibernateImpl implements BookDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<Book> findAll() {
        List<Book> listbook = new ArrayList<>();

        listbook = session.createCriteria(Book.class).list();

        return listbook;
    }

    @Override
    public Book save(Book book) {
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();

        return book;
    }

    @Override
    public boolean deleteAll() {

        boolean returnRes = false;
        List<Book> listBook;

        listBook = findAll();

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
        
        return returnRes;

    }
}
