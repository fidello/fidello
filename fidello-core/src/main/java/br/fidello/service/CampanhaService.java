package br.fidello.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fidello.delegate.CampanhaDelegate;
import br.com.fidello.json.CampanhaVO;
import br.com.fidello.json.CompraVO;

@Path("/campanha")
@Produces({ MediaType.APPLICATION_JSON })
public class CampanhaService {

	@Inject
	CampanhaDelegate campanhaDelegate;

	@GET
	@Path("/")
	public String teste() {
		return "CampanhaService implantado com sucesso";
	}

	@POST
	@Path("/")
	public Response cadastrarCampanha(CampanhaVO campanhaVO) {

		try {

			campanhaDelegate.cadastrarCampanha(campanhaVO);

			return Response.status(200)
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "X-Requested-With")
					.entity("").build();

			
		} catch (Exception e) {
			return Response.serverError().entity(e).build();

		}

	}
	
	@GET
	@Path("/pontuar")
	public Response pontuar() {

		try {

			CompraVO compra = new CompraVO();
			
			campanhaDelegate.pontuar(compra);

			return Response.status(200)
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "X-Requested-With")
					.entity("").build();

			
		} catch (Exception e) {
			return Response.serverError().entity(e).build();

		}

	}
	
	@GET
	@Path("/pontos")
	public Response pontos() {

		try {
			Integer idPessoa = 11;
			
			
			Double pontos = campanhaDelegate.detalharPontosPorPessoa(idPessoa);

			return Response.status(200)
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "X-Requested-With")
					.entity(pontos).build();

			
		} catch (Exception e) {
			return Response.serverError().entity(e).build();

		}

	}


}
