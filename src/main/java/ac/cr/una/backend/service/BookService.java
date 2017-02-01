package ac.cr.una.backend.service;

import ac.cr.una.backend.model.Book;
import java.util.List;

public interface BookService {

    public List<Book> findAll();

    public Book save(Book book);

    public boolean deleteAll();
    
    public float totalPriceAll();
}
