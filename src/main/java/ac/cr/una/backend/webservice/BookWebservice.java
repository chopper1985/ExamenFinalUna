package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.BookDAO;
import ac.cr.una.backend.dao.BookDAOHibernateImpl;
import ac.cr.una.backend.model.Book;
import ac.cr.una.backend.service.BookService;
import ac.cr.una.backend.service.BookServiceImpl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Josue
 */
@Path("books")
public class BookWebservice {

    private BookDAO bookDAO;
    private BookService bookService;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StudentResource
     */
    public BookWebservice() {
    }

    /**
     *
     * @return
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBook() {
        List<Book> bookList = null;
        bookDAO = new BookDAOHibernateImpl();
        bookService = new BookServiceImpl(bookDAO);

        bookList = bookService.findAll();

        return bookList;
    }

    /**
     *
     * @param book
     * @return
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book createBook(Book book) {

        bookDAO = new BookDAOHibernateImpl();
        bookService = new BookServiceImpl(bookDAO);

        book = bookService.save(book);

        return book;
    }

    /**
     *
     * @return
     */
    @DELETE
    @Path("/")
    public boolean deleteAll() {
        boolean result;
        bookDAO = new BookDAOHibernateImpl();
        bookService = new BookServiceImpl(bookDAO);

        result = bookService.deleteAll();

        return result;
    }

    /**
     *
     * @return
     */
    @GET
    @Path("/totalprice")
    public float getTotalPrice() {
        float result;
        bookDAO = new BookDAOHibernateImpl();
        bookService = new BookServiceImpl(bookDAO);

        result = bookService.totalPriceAll();

        return result;
    }

}
