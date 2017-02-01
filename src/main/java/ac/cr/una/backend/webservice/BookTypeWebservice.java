
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.BookTypeDAO;
import ac.cr.una.backend.dao.BookTypeDAOHibernateImpl;
import ac.cr.una.backend.model.BookType;
import ac.cr.una.backend.service.BookTypeService;
import ac.cr.una.backend.service.BookTypeServiceImpl;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


@Path("booktypes")
public class BookTypeWebservice {

    private BookTypeDAO bookTypeDAO;
    private BookTypeService bookTypeService;

    @Context
    private UriInfo context;

    public BookTypeWebservice() {
    }
    
    
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookType getByName(@PathParam("name") String name) {
        BookType book = null;
        bookTypeDAO = new BookTypeDAOHibernateImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

        book = bookTypeService.findByName(name);

        return book;
    }

  
    @DELETE
    @Path("/")
    public boolean deleteAll() {
        boolean result;
        bookTypeDAO = new BookTypeDAOHibernateImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

        result = bookTypeService.deleteAll();

        return result;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BookType createBookType(BookType bookType ){

        bookTypeDAO = new BookTypeDAOHibernateImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

        bookType = bookTypeService.save(bookType);

        return bookType;
    }

}
