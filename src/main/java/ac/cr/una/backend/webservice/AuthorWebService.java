/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.AuthorDAO;
import ac.cr.una.backend.dao.AuthorDAOImpl;
import ac.cr.una.backend.dao.ConsultorioDAOHibernateImpl;
import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.model.Consultorio;
import ac.cr.una.backend.service.AuthorService;
import ac.cr.una.backend.service.AuthorServiceImpl;
import ac.cr.una.backend.service.ConsultorioServiceImpl;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Josue
 */
@Path("authors")
public class AuthorWebService {

    private AuthorDAO autorDAO;
    private AuthorService autorService;

    @Context
    private UriInfo context;

    public AuthorWebService() {
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Author getAuthor(@PathParam("name") String name) {
        Author autor = null;
        autorDAO = new AuthorDAOImpl();
        autorService = new AuthorServiceImpl(autorDAO);

        autor = autorService.findByName(name);

        return autor;
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAllAuthors() {
        List<Author> authorList = null;
        autorDAO = new AuthorDAOImpl();
        autorService = new AuthorServiceImpl(autorDAO);

        authorList = autorService.findAll();

        return authorList;
    }
}
