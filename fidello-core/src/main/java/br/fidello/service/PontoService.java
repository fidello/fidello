package br.fidello.service;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fidello.delegate.LojaDelegate;
import br.com.fidello.delegate.PontoDelegate;
import br.com.fidello.model.Campanha;
import br.com.fidello.model.Loja;
import br.com.fidello.model.Pessoa;
import br.com.fidello.model.Ponto;

@Path("/ponto")
@Produces({ MediaType.APPLICATION_JSON })
public class PontoService {

	@Inject
	PontoDelegate pontoDelegate;

	
	@GET
	@Path("/")
	public String teste() {
		return "PontoService implantado com sucesso"; 
	}
	
	@POST
	@Path("/")
	public Response cadastrarLoja(Pessoa pessoa, Ponto ponto, Loja loja, Campanha campanha) {

		try {
			pontoDelegate.fornecerPontos(pessoa, ponto, loja, campanha);
			return Response.status(200)
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "X-Requested-With")
					.entity("").build();
		} catch (Exception e) {
			return Response.serverError().entity(e).build();

		}

	}

	
	
}
