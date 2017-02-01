package ac.cr.una.backend.service;

import ac.cr.una.backend.dao.BookDAO;
import ac.cr.una.backend.model.Book;
import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    public BookServiceImpl() {
    }

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookDAO.save(book);
    }

    @Override
    public boolean deleteAll() {

        return bookDAO.deleteAll();
    }

    @Override
    public float totalPriceAll() {
        List<Book> listBook;

        float temp = 0;

        listBook = bookDAO.findAll();

        for (Book item : listBook) {
            temp += item.getPrice();
        }

        return temp;
    }

}
