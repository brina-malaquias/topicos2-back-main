package br.unitins.projeto.resource.produto;


import java.io.IOException;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.projeto.application.Result;
import br.unitins.projeto.dto.produto.nicSalt.NicSaltDTO;
import br.unitins.projeto.dto.produto.nicSalt.NicSaltResponseDTO;
import br.unitins.projeto.form.CoilImageForm;
import br.unitins.projeto.form.NicSaltImageForm;
import br.unitins.projeto.service.file.FileService;
import br.unitins.projeto.service.produto.nicSalt.NicSaltService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status; 

@Path("/nicSalts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NicSaltResource {
    @Inject
    NicSaltService service;

    @Inject
    FileService fileService;

    private static final Logger LOG = Logger.getLogger(NicSaltResource.class);

    @POST
    public Response create(NicSaltDTO dto) {
        NicSaltResponseDTO retorno = service.create(dto);
        //return Response.status(Status.CREATED).entity(retorno).build();
        return Response.status(201).entity(retorno).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(NicSaltDTO dto, @PathParam("id") Long id) {
        service.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
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
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(service.findByNome(nome)).build();
    }
    
    @GET
    @Path("/count")
    public long count(){
        return service.count();
    }

    @GET
    @Path("/image/download/{nomeImagem}")
    @RolesAllowed({"Administrador", "Comum"})
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        Response.ResponseBuilder response = Response.ok(fileService.download(nomeImagem, "nicSalt"));
        response.header("Content-Disposition", "attachment;filename=" + nomeImagem);
        return response.build();
    }

    @PATCH
    @Path("/image/upload")
    @RolesAllowed({"Administrador"})
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm NicSaltImageForm form){
        try {
            service.salvarImagens(form);
            return Response.noContent().build();
        } catch (IOException e) {
            Result result = new Result(e.getMessage());
            return Response.status(Status.CONFLICT).entity(result).build();
        }
    }

}
