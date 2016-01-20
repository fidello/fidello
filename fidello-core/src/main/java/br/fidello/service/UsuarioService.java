package br.fidello.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.fidello.delegate.PessoaDelegate;
import br.com.fidello.delegate.UsuarioDelegate;
import br.com.fidello.json.LoginVO;
import br.com.fidello.json.PessoaVO;
import br.com.fidello.json.UsuarioVO;

@Path("/usuario")
@Produces({ MediaType.APPLICATION_JSON })
public class UsuarioService {

	@Inject
	UsuarioDelegate usuarioDelegate;

	@Inject
	PessoaDelegate pessoaDelegate;

	@GET
	@Path("/")
	public String teste() {
		return "UsuarioService implantado com sucesso";
	}

	@GET
	@Path("/testeSalvar")
	public Response salvarUsuarioTeste() {

		try {
			UsuarioVO usuarioVO = new UsuarioVO();

			usuarioVO.setDocumento("02546275100");
			usuarioVO.setSenha("123");
			usuarioVO.setEmail("gomes@gmail.com");
			usuarioVO.setNome("Gomes");

			usuarioDelegate.cadastrarUsuario(usuarioVO);
			return Response.status(200).entity("Usuario Salvo com sucesso")
					.build();
		} catch (Exception e) {
			return Response.serverError().entity(e).build();

		}

	}

	@GET
	@Path("/pessoas")
	public Response buscarPessoasFisicas() {
		List<PessoaVO> pessoas = null;
		try {

			pessoas = pessoaDelegate.buscarPessoasFisicas();
			return Response.status(200).entity(pessoas).build();

		} catch (Exception e) {
			return Response.serverError().entity(e).build();

		}

	}

	@POST
	@Path("/")
	public Response salvarUsuario(UsuarioVO usuarioVO) {

		try {

			usuarioDelegate.cadastrarUsuario(usuarioVO);

			return Response.status(200).entity("").build();

		} catch (Exception e) {
			return Response.serverError().entity(e).build();

		}

	}

	@POST
	@Path("login")
	public Response login(LoginVO login) {

		try {
			UsuarioVO usuarioVO = usuarioDelegate.loginUsuario(login);
			return Response.status(200).entity(usuarioVO).build();
		} catch (Exception e) {
			return Response.serverError().entity(e).build();

		}

	}

}
