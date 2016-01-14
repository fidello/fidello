package br.fidello.service;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fidello.delegate.LojaDelegate;
import br.com.fidello.model.Loja;

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
	public Response cadastrarLoja(Loja loja) {

		try {
			lojaDelegate.cadastrarLoja(loja);
			return Response.status(200)
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "X-Requested-With")
					.entity("").build();
		} catch (Exception e) {
			return Response.serverError().entity(e).build();

		}

	}

	
	
}
