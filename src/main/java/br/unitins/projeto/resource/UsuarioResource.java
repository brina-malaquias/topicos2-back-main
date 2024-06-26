package br.unitins.projeto.resource;

import java.util.List;

import br.unitins.projeto.dto.usuario.cadastro.CadastroDTO;
import org.jboss.logging.Logger;

import br.unitins.projeto.application.Result;
import br.unitins.projeto.dto.usuario.UsuarioResponseDTO;
import br.unitins.projeto.dto.usuario.cadastro.CadastroAdminDTO;
import br.unitins.projeto.dto.usuario.cadastro.CadastroAdminResponseDTO;
import br.unitins.projeto.model.Perfil;
import br.unitins.projeto.service.usuario.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
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

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService service;

    private static final Logger LOG = Logger.getLogger(UsuarioResource.class);

    @GET
//    @RolesAllowed({"Admin"})
    public List<UsuarioResponseDTO> getAll() {
        LOG.info("Buscando todos os usuarios.");
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Administrador"})
    public UsuarioResponseDTO findById(@PathParam("id") Long id) {
        LOG.info("Buscando um usuario pelo id.");
        return service.findById(id);
    }

    @POST
    @RolesAllowed({"Administrador", "Comum"})
    public Response insert(@Valid CadastroDTO dto) {
        LOG.infof("Inserindo um usuario: %s", dto.nome());
        Result result = null;

        try {
            UsuarioResponseDTO response = service.create(dto);
            LOG.infof("Usuario (%d) criado com sucesso.", response.id());
            return Response.status(Status.CREATED).entity(response).build();
        } catch (ConstraintViolationException e) {
            LOG.error("Erro ao incluir um usuario.");
            LOG.debug(e.getMessage());
            result = new Result(e.getConstraintViolations());
        } catch (Exception e) {
            LOG.fatal("Erro sem identificacao: " + e.getMessage());
            result = new Result(e.getMessage(), false);
        }

        return Response.status(Status.NOT_FOUND).entity(result).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Administrador", "Comum"})
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Deletando um usuario: %s", id);
        Result result = null;

        try {
            service.delete(id);
            LOG.infof("Usuario (%d) deletado com sucesso.", id);
            return Response.status(Status.NO_CONTENT).build();
        } catch (ConstraintViolationException e) {
            LOG.error("Erro ao deletar um usuario.");
            LOG.debug(e.getMessage());
            result = new Result(e.getConstraintViolations());
        } catch (Exception e) {
            LOG.fatal("Erro sem identificacao: " + e.getMessage());
            result = new Result(e.getMessage(), false);
        }

        return Response.status(Status.NOT_FOUND).entity(result).build();
    }

    @GET
    @Path("/search")
    @RolesAllowed({"Administrador"})
    public Response search(@QueryParam("page") int pageNumber,
                           @QueryParam("size") int pageSize,
                           @QueryParam("campoBusca") String campoBusca,
                           @QueryParam("situacao") String situacao) {
        LOG.infof("Pesquisando usuarios pelo campoBusca: %s", campoBusca);
        Result result = null;

        try {
            List<CadastroAdminResponseDTO> response = service.findByCampoBusca(campoBusca, situacao, pageNumber, pageSize);
            LOG.infof("Pesquisa realizada com sucesso.");
            return Response.ok(response).build();
        } catch (ConstraintViolationException e) {
            LOG.error("Erro ao pesquisar usuarios.");
            LOG.debug(e.getMessage());
            result = new Result(e.getConstraintViolations());
        } catch (Exception e) {
            LOG.fatal("Erro sem identificacao: " + e.getMessage());
            result = new Result(e.getMessage(), false);
        }

        return Response.status(Status.NOT_FOUND).entity(result).build();
    }

    @GET
    @Path("/search/count")
    public Long count(@QueryParam("campoBusca") String campoBusca,
                      @QueryParam("situacao") String situacao
    ) {
        return service.countByCampoBusca(campoBusca, situacao);
    }

    @PUT
    @Path("admin/situacao/{id}")
//    @RolesAllowed({"Admin"})
    public Response alterarSituacao(@PathParam("id") Long id, Boolean situacao) {
        LOG.infof("Alterando situação da categoria");
        Result result = null;

        try {
            CadastroAdminResponseDTO response = service.alterarSituacao(id, situacao);
            LOG.infof("Categoria (%d) alterado com sucesso.", response.id());
            return Response.ok(response).build();
        } catch (ConstraintViolationException e) {
            LOG.error("Erro ao alterar uma categoria.");
            LOG.debug(e.getMessage());
            result = new Result(e.getConstraintViolations());
        } catch (Exception e) {
            LOG.fatal("Erro sem identificacao: " + e.getMessage());
            result = new Result(e.getMessage(), false);
        }

        return Response.status(Status.NOT_FOUND).entity(result).build();
    }

    @GET
    @Path("/admin/paginado")
    public List<CadastroAdminResponseDTO> getAllPaginado(
            @QueryParam("page") int pageNumber,
            @QueryParam("size") int pageSize
    ) {
        return service.findAllAdminPaginado(pageNumber, pageSize);
    }

    @GET
    @Path("/admin/{id}")
    public CadastroAdminResponseDTO findByIdPorAdmin(@PathParam("id") Long id) {
        return service.findByIdPorAdmin(id);
    }

    @GET
    @Path("/admin/count")
    public Long count() {
        return service.count();
    }

    @POST
    @Path("/admin")
    public Response insertAdmin(@Valid CadastroAdminDTO dto) {
        LOG.infof("Inserindo um usuario: %s", dto.nome());
        Result result = null;

        try {
            CadastroAdminResponseDTO response = service.cadastrarPorAdmin(dto);
            LOG.infof("Usuario (%d) criado com sucesso.", response.id());
            return Response.status(Status.CREATED).entity(response).build();
        } catch (ConstraintViolationException e) {
            LOG.error("Erro ao incluir um usuario.");
            LOG.debug(e.getMessage());
            result = new Result(e.getConstraintViolations());
        } catch (Exception e) {
            LOG.fatal("Erro sem identificacao: " + e.getMessage());
            result = new Result(e.getMessage(), false);
        }

        return Response.status(Status.NOT_FOUND).entity(result).build();
    }

    @PUT
    @Path("/admin/{id}")
    public Response updateAdmin(@PathParam("id") Long id, @Valid CadastroAdminDTO dto) {
        LOG.infof("Alterando um usuario: %s", dto.nome());
        Result result = null;

        try {
            CadastroAdminResponseDTO response = service.alterarPorAdmin(id, dto);
            LOG.infof("Usuario (%d) alterado com sucesso.", response.id());
            return Response.ok(response).build();
        } catch (ConstraintViolationException e) {
            LOG.error("Erro ao alterar um usuario.");
            LOG.debug(e.getMessage());
            result = new Result(e.getConstraintViolations());
        } catch (Exception e) {
            LOG.fatal("Erro sem identificacao: " + e.getMessage());
            result = new Result(e.getMessage(), false);
        }

        return Response.status(Status.NOT_FOUND).entity(result).build();
    }

    @GET
    @Path("/perfis")
    public Response getPerfis(){
        return Response.ok(Perfil.values()).build();
    }
}