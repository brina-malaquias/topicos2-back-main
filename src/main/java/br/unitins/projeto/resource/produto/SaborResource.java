package br.unitins.projeto.resource.produto;
import jakarta.annotation.security.RolesAllowed;
import org.jboss.logging.Logger;

import br.unitins.projeto.dto.produto.sabor.SaborDTO;
import br.unitins.projeto.dto.produto.sabor.SaborResponseDTO;
import br.unitins.projeto.service.produto.sabor.SaborService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status; 

@Path("/sabores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SaborResource {

    @Inject
    SaborService service;

    private static final Logger LOG = Logger.getLogger(SaborResource.class);

    @POST
    @RolesAllowed({"Administrador"})
    public Response create(SaborDTO dto) {
        SaborResponseDTO retorno = service.create(dto);
        //return Response.status(Status.CREATED).entity(retorno).build();
        return Response.status(201).entity(retorno).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @RolesAllowed({"Administrador"})
    public Response update(SaborDTO dto, @PathParam("id") Long id) {
        service.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @RolesAllowed({"Administrador"})
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    public Response findAll(
                @QueryParam("page") @DefaultValue("0") int page,
                @QueryParam("pageSize") @DefaultValue("100") int pageSize) {

        return Response.ok(service.getAll(page, pageSize)).build();
    }


    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }
    
    @GET
    @Path("/search/nome/{sabor}")
    public Response findByNome(@PathParam("sabor") String sabor) {
        return Response.ok(service.findByNome(sabor)).build();
    }
        
    @GET
    @Path("/count")
    public long count(){
        return service.count();
    }
    
}
