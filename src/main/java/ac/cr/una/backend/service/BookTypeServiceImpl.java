package ac.cr.una.backend.service;

import ac.cr.una.backend.dao.BookDAO;
import ac.cr.una.backend.dao.BookTypeDAO;
import ac.cr.una.backend.model.BookType;

public class BookTypeServiceImpl implements BookTypeService {

    private BookTypeDAO bookTypeDAO;

    public BookTypeServiceImpl() {
    }

    public BookTypeServiceImpl(BookTypeDAO bookTypeDAO) {
        this.bookTypeDAO = bookTypeDAO;
    }


    public BookTypeDAO getBookTypeDAO() {
        return bookTypeDAO;
    }

    public void setBookTypeDAO(BookTypeDAO bookTypeDAO) {
        this.bookTypeDAO = bookTypeDAO;
    }

    @Override
    public BookType findByName(String name) {
        return bookTypeDAO.findByName(name);
    }

    @Override
    public BookType save(BookType bookType) {
        return bookTypeDAO.save(bookType);
    }

    @Override
    public boolean deleteAll() {
        return bookTypeDAO.deleteAll();
    }

}
