package br.fidello.service;

import javax.ws.rs.core.Response;

public class RestService {

	public Response getRespostaErro(Exception e) {
		if (e.getMessage() != null && !e.getMessage().isEmpty())
			return Response.serverError().header("Access-Control-Allow-Origin", "*").entity(e.getMessage()).build();

		return Response.serverError().header("Access-Control-Allow-Origin", "*").entity(e.getCause()).build();

	}

	public Response getRepostaSucesso(Object entity) {
		return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(entity).build();
	}

}
