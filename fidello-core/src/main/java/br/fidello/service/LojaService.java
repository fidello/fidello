package br.fidello.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fidello.delegate.LojaDelegate;
import br.com.fidello.json.LojaVO;

@Path("/loja")
@Produces({ MediaType.APPLICATION_JSON })
public class LojaService {

	@Inject
	LojaDelegate lojaDelegate;

	@GET
	@Path("/")
	public String teste() {
		return "LojaService implantado com sucesso";
	}

	@POST
	@Path("/")
	public Response cadastrarLoja(LojaVO loja) {

		try {
			lojaDelegate.cadastrarLoja(loja, loja.getIdPessoa());
			return Response.status(200).entity("").build();
		} catch (Exception e) {
			return Response.serverError().entity(e).build();

		}

	}

	@GET
	@Path("/lojas/{id}")
	public Response listarLojasPorUsuario(@PathParam("id") Integer id) {

		try {
			List<LojaVO> lojas = lojaDelegate.listarLojasPorUsuario(id);
			return Response.status(200).entity(lojas).build();
		} catch (Exception e) {
			return Response.serverError().entity(e).build();

		}

	}

}
