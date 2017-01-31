
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.ConsultorioDAOHibernateImpl;
import ac.cr.una.backend.dao.ConsultorioDAO;
import ac.cr.una.backend.model.Consultorio;
import ac.cr.una.backend.service.ConsultorioService;
import ac.cr.una.backend.service.ConsultorioServiceImpl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


@Path("consultorios")
public class ConsultorioWebservice {

    private ConsultorioDAO consultorioDAO;
    private ConsultorioService consultorioService;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StudentResource
     */
    public ConsultorioWebservice() {
    }

    /**
     * Retrieves All the Students
     *
     * @return Student
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consultorio> getAllConsultorios() {
        List<Consultorio> consultorioList = null;
        consultorioDAO = new ConsultorioDAOHibernateImpl();
        consultorioService = new ConsultorioServiceImpl(consultorioDAO);

        consultorioList = consultorioService.findAll();

        return consultorioList;
    }

    /**
     * Retrieves only one student
     *
     * @param text
     * @return Student
     */
    @GET
    @Path("/{text}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consultorio> getConsultorios(@PathParam("text") String text) {
        List<Consultorio> consultorioList = null;
        consultorioDAO = new ConsultorioDAOHibernateImpl();
        consultorioService = new ConsultorioServiceImpl(consultorioDAO);
        consultorioList = consultorioService.findByName(text);

        return consultorioList;
    }

    /**
     * Create a new Student
     *
     * @param consultorio
     * @return student
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Consultorio createConsultorio(Consultorio consultorio) {

        consultorioDAO = new ConsultorioDAOHibernateImpl();
        consultorioService = new ConsultorioServiceImpl(consultorioDAO);

        consultorio = consultorioService.save(consultorio);

        return consultorio;
    }

    /**
     * Delete a new Student
     *
     * @param id
     * @return student
     */
    @DELETE
    @Path("/{id}")
    public boolean deleteConsultorio(@PathParam("id") int id) {
        boolean result;
        consultorioDAO = new ConsultorioDAOHibernateImpl();
        consultorioService = new ConsultorioServiceImpl(consultorioDAO);

        result = consultorioService.delete(id);

        return result;
    }

    /**
     * Update a Student
     *
     * @param consultorio
     * @return student
     */
    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Consultorio updateConsultorio(Consultorio consultorio) {

        consultorioDAO = new ConsultorioDAOHibernateImpl();
        consultorioService = new ConsultorioServiceImpl(consultorioDAO);

        consultorio = consultorioService.update(consultorio);

        return consultorio;
    }

}
